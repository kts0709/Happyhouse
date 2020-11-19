<template>
  <div>
    <index-header></index-header>
    <title-img></title-img>
    <br />
    <h2>Q & A 작성</h2>
    <div id="qnawrite">
      <div id="noticegroup" class="form-group">
        <label for="qnaUserid">작성자 ID</label>

        <input
          class="form-control"
          id="qnaUserid"
          ref="qnaUserid"
          :placeholder="memberid"
          v-model="qnaUserid"
          readonly
        />
      </div>

      <div id="noticegroup" class="form-group">
        <label for="title">질문</label>
        <input
          type="text"
          class="form-control"
          id="qnaTitle"
          ref="qnaTitle"
          placeholder="제목을 입력하세요"
          v-model="qnaTitle"
        />
      </div>
      <div id="noticegroup" class="form-group">
        <label for="content">질문 내용</label>
        <textarea
          class="form-control"
          id="qnaContent"
          ref="qnaContent"
          placeholder="내용을 입력하세요"
          v-model="qnaContent"
        ></textarea>
      </div>

      <div class="text-center">
        <button class="btn btn-primary" @click="handler" style="border: 1px solid #172b4d; background-color:#172b4d; color:white;">Q & A 등록</button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import IndexHeader from "@/layouts/IndexHeader.vue";
import TitleImg from "@/layouts/TitleImg.vue";
export default {
  name: "Save",
  data() {
    return {
      qnaTitle: "",
      qnaContent: "",
      qnaUserid: "",
      memberid:""
    };
  },
  components: {
    IndexHeader,
    TitleImg
  },
  async created() {
    this.memberid = await this.$session.get('memberid');
  },
  methods: {
    handler() {
      let err = true;
      let msg = "";
      !this.qnaTitle &&
        ((msg = "제목 입력해주세요"),
        (err = false),
        this.$refs.qnaTitle.focus());
      err &&
        !this.qnaContent &&
        ((msg = "내용 입력해주세요"),
        (err = false),
        this.$refs.qnaContent.focus());
      if (!err) alert(msg);
      else this.createHandler();
    },
    createHandler() {
      axios
        .post("http://localhost:9999/ssafy/api/qna", {
          qnaTitle: this.qnaTitle,
          qnaContent: this.qnaContent,
          qnaUserid: this.memberid
        })
        .then(() => {
          alert("Q & A 등록 완료");
          this.$router.push("/list");
        });
    }
  }
};
</script>
<style>
#qnawrite {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 800px;
  margin: auto;
  padding: auto;
}
</style>