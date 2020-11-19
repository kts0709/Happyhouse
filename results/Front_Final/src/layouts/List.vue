<template>
  <div>
    <index-header></index-header>
    <title-img></title-img>
    <br />
    <h2 class="text-center" style="font-family: 'Muli', sans-serif;">Q & A</h2>
    <br />
    <div v-if="items.length">
      <table id="qna">
        <colgroup>
          <col :style="{ width: '10%' }" />
          <col :style="{ width: '40%' }" />
          <col :style="{ width: '15%' }" />
          <col :style="{ width: '15%' }" />
        </colgroup>
        <tr >
          <th style="background-color:#172b4d; color:white;">번호</th>
          <th style="background-color:#172b4d; color:white;">제 목</th>
          <th style="background-color:#172b4d; color:white;">질문자</th>
          <th style="background-color:#172b4d; color:white;">일 시</th>
        </tr>
        <tr v-for="(q, index) in items" :key="index + '_items'">
          <td>
            <router-link :to="'detail?qnaNo=' + q.qnaNo">
              {{
              q.qnaNo
              }}
            </router-link>
          </td>
          <td>
            <router-link :to="'detail?qnaNo=' + q.qnaNo">
              {{
              q.qnaTitle
              }}
            </router-link>
          </td>
          <td>{{ q.qnaUserid }}</td>
          <td>{{ getFormatDate(q.qnaDatetime) }}</td>
        </tr>
      </table>
    </div>
    <div v-else class="text-center">게시글이 없습니다.</div>
    <br />
    <template v-if="memberid">
    <div>
      <router-link :to="'/save'">
        <button class="btn btn-secondary"         style="border: 1px solid #172b4d; background-color:#172b4d; color:white;">Q & A 작성</button>
      </router-link>
    </div>
    </template>
  </div>
</template>

<script>
import axios from "axios";
import moment from "moment";
import IndexHeader from "@/layouts/IndexHeader.vue";
import TitleImg from "@/layouts/TitleImg.vue";

export default {
  name: "List",
  data: function() {
    return {
      query: "",
      items: [],
      memberid:""
    };
  },
  components: {
    IndexHeader,
    TitleImg
  },

  created() {
    axios.get("http://localhost:9999/ssafy/api/qna").then(({ data }) => {
      this.items = data;
        this.memberid =  this.$session.get('memberid');
    });
  },
  methods: {
    getFormatDate(regtime) {
      return moment(new Date(regtime)).format("YYYY.MM.DD HH:mm:ss");
    }
  }
};
</script>

<style>
#qna {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 80%;
  margin: auto;
  padding: auto;
}

#qna td,
#qna th {
  border: 1px solid #ddd;
  padding: 8px;
}

#qna tr:nth-child(even) {
  background-color: #f2f2f2;
}

#qna tr:hover {
  background-color: #ddd;
}

#qna th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: center;
  background-color: #070844;
  color: white;
}
</style>