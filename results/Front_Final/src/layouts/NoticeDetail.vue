<template>
  <div>
    <index-header></index-header>
    <title-img></title-img>
    <br />
    <h2>공지 합니다!</h2>
    <div class="text-align">
      <table id="noticedetail" class="table table-condensed w-25">
        <tr>
          <td id="title" style="background-color:#172b4d; color:white;">
            <strong>No.</strong>
          </td>
          <td id="contents">{{ notice.noticeno }}</td>
        </tr>

        <tr>
          <td id="title" style="background-color:#172b4d; color:white;">
            <strong>작성자</strong>
          </td>
          <td id="contents">{{ notice.memberid }}</td>
        </tr>

        <tr>
          <td id="title" style="background-color:#172b4d; color:white;">
            <strong>공지 사항</strong>
          </td>
          <td id="contents">{{ notice.subject }}</td>
        </tr>

        <tr>
          <td id="title" style="background-color:#172b4d; color:white;">
            <strong>공지 내용</strong>
          </td>
          <td id="contents">{{ notice.content }}</td>
        </tr>
      </table>
      <br />
      <div class="text-center">
        <router-link :to="'/NoticeList'">
          <button class="btn btn-primary" style="border: 1px solid #172b4d; background-color:#172b4d; color:white;">목록</button>&emsp;&emsp;&emsp;
        </router-link>&emsp;&emsp;&emsp;
             <template v-if="memberid == 'admin'">
        <router-link :to="'/NoticeUpdate?noticeno=' + notice.noticeno">
          <button class="btn btn-secondary">수정</button>
        </router-link>&emsp;&emsp;&emsp;
        <router-link :to="'/NoticeDelete?noticeno=' + notice.noticeno">
          <button class="btn btn-warning">삭제</button>
        </router-link>
             </template>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import moment from "moment";
import IndexHeader from "@/layouts/IndexHeader.vue";
import TitleImg from "@/layouts/TitleImg.vue";
export default {
  name: "NoticeDetail",
  data: function() {
    return {
      notice: {},
      memberid:""
    };
  },
  components: {
    IndexHeader,
    TitleImg
  },
  created() {
    this.memberid = this.$session.get("memberid");
    const params = new URL(document.location).searchParams;
    axios
      .get(`http://localhost:9999/ssafy/api/notice/${params.get("noticeno")}`)
      .then(({ data }) => {
        this.notice = data;
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
#noticedetail {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  /* width: 80%; */
  margin: auto;
  padding: auto;
  table-layout: fixed;
}

#noticedetail td,
#noticedetail th {
  border: 1px solid #ddd;
  padding: 8px;
}

#noticedetail tr:nth-child(even) {
  background-color: #f2f2f2;
}

#noticedetail tr:hover {
  background-color: #ddd;
}

#title {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: center;
  background-color: #070844;
  color: white;
  width: 100px;
}

#contents {
  width: 500px;
}
</style>