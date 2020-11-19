<template>
  <div>
    <index-header></index-header>
    <title-img></title-img>
    <br />
    <h2>Q & A 수정</h2>
    <div>
      <div id="noticewrite">
        <div id="noticegroup" class="form-group">
          <label for="title">제목</label>
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
          <label for="content">내용</label>
          <textarea
            class="form-control"
            id="qnaContent"
            ref="qnaContent"
            placeholder="내용을 입력하세요"
            v-model="qnaContent"
          ></textarea>
        </div>
        <div class="text-center">
          <button class="btn btn-primary" @click="handler" style="border: 1px solid #172b4d; background-color:#172b4d; color:white;">>Update</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import IndexHeader from "@/layouts/IndexHeader.vue";
import TitleImg from "@/layouts/TitleImg.vue";
export default {
  name: "Update",
  data() {
    return {
      qnaTitle: "",
      qnaContent: "",
      qnaUserid: "",
      qnaNo: ""
    };
  },
  components: {
    IndexHeader,
    TitleImg
  },
  created() {
    const params = new URL(document.location).searchParams;
    axios
      .get(`http://localhost:9999/ssafy/api/qna/${params.get("qnaNo")}`)
      .then(({ data }) => {
        this.qnaTitle = data.qnaTitle;
        this.qnaContent = data.qnaContent;
        this.qnaUserid = data.qnaUserid;
        this.qnaNo = data.qnaNo;
      });
  },
  methods: {
    handler() {
      this.createHandler();
    },
    createHandler() {
      axios
        .put("http://localhost:9999/ssafy/api/qna/" + this.qnaNo, {
          qnaTitle: this.qnaTitle,
          qnaContent: this.qnaContent,
          qnaUserid: this.qnaUserid,
          qnaNo: this.qnaNo
        })
        .then(() => {
          alert("수정된 Q&A가 등록되었습니다.");
          this.$router.push("/list");
        });
    }
  }
};
</script>
