<template>
  <div>
    <index-header></index-header>
    <title-img></title-img>
    <br />
    <h2 class="text-center" style="font-family: 'Muli', sans-serif;">Notice to Our Member!</h2>
    <br />
    <div v-if="items.length">
      <table id="notice">
        <colgroup>
          <col :style="{ width: '10%' }" />
          <col :style="{ width: '15%' }" />
          <col :style="{ width: '30%' }" />
          <col :style="{ width: '20%' }" />
        </colgroup>
        <tr>
          <th style="background-color:#172b4d; color:white;">No.</th>
          <th style="background-color:#172b4d; color:white;">ID</th>
          <th style="background-color:#172b4d; color:white;">Notice</th>
          <th style="background-color:#172b4d; color:white;">Update Time</th>
        </tr>

        <tr v-for="(notice, index) in items" :key="index + '_items'">
          <td>{{ notice.noticeno }}</td>
          <td>{{ notice.memberid }}</td>
          <td>
            <router-link :to="'NoticeDetail?noticeno=' + notice.noticeno">
              {{
              notice.subject
              }}
            </router-link>
          </td>
          <td>{{ notice.regtime }}</td>
        </tr>
      </table>
    </div>

    <div v-else class="text-center">공지사항이 없습니다.</div>
    <br />
         <template v-if="sessionid == 'admin'">
    <div>
      
      <router-link :to="'/NoticeWrite'">
        <button class="btn btn-secondary" style="border: 1px solid #172b4d; background-color:#172b4d; color:white;">공지 사항 등록</button>
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
  name: "NoticeList",
  data: function() {
    return {
      query: "",
      items: [],
      sessionid:""
    };
  },
  components: {
    IndexHeader,
    TitleImg
  },
  created() {
    axios.get("http://localhost:9999/ssafy/api/notice").then(({ data }) => {
      this.items = data;
    });
         this.sessionid = this.$session.get("memberid");
  },
  methods: {
    getFormatDate(regtime) {
      return moment(new Date(regtime)).format("YYYY.MM.DD HH:mm:ss");
    }
  }
};
</script>

<style>
#notice {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 80%;
  margin: auto;
  padding: auto;
}

#notice td,
#notice th {
  border: 1px solid #ddd;
  padding: 8px;
}

#notice tr:nth-child(even) {
  background-color: #f2f2f2;
}

#notice tr:hover {
  background-color: #ddd;
}

#notice th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: center;
  background-color: #070844;
  color: white;
}
</style>