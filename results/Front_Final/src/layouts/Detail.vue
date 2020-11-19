<template>
  <div>
    <index-header></index-header>
    <title-img></title-img>
    <br />
    <h2>Q & A</h2>
    <div class="text-align">
      <table id="noticedetail" class="table table-condensed w-25">
        <tr>
          <td id="title" style="background-color:#172b4d; color:white;">
            작성자 ID
          </td>
          <td id="contents">{{ q.qnaUserid }}</td>
        </tr>

        <tr>
          <td id="title" style="background-color:#172b4d; color:white;">
            작성 시간
          </td>

          <td id="contents">{{ getFormatDate(q.qnaDatetime) }}</td>
        </tr>
        <tr>
          <td id="title" style="background-color:#172b4d; color:white;">
            질문
          </td>
          <td id="contents">{{ q.qnaTitle }}</td>
        </tr>
        <tr>
          <td id="title" style="background-color:#172b4d; color:white;">
            질문 내용
          </td>
          <td id="contents">{{ q.qnaContent }}</td>
        </tr>
      </table>

      <br />
      <div class="text-center">
        <router-link :to="'/list'">
          <button
            class="btn btn-primary"
            style="border: 1px solid #172b4d; background-color:#172b4d; color:white;"
          >
            목록
          </button> </router-link
        >&emsp;&emsp;

        <template v-if="q.qnaUserid == memberid || memberid === 'admin'">
          <router-link :to="'/update?qnaNo=' + q.qnaNo">
            <button class="btn btn-secondary">수정</button> </router-link
          >&emsp;&emsp;
          <router-link :to="'/delete?qnaNo=' + q.qnaNo">
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
  name: "Detail",
  data: function() {
    return {
      q: {},
      memberid: ""
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
      .get(`http://localhost:9999/ssafy/api/qna/${params.get("qnaNo")}`)
      .then(({ data }) => {
        console.log(data);
        this.q = data;
      });
  },
  methods: {
    getFormatDate(regtime) {
      return moment(new Date(regtime)).format("YYYY.MM.DD HH:mm:ss");
    }
  }
};
</script>
