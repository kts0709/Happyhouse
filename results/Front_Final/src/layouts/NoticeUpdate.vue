<template>
  <div>
    <index-header></index-header>
    <title-img></title-img>
    <br />
    <h2>공지 사항 수정</h2>
    <div id="noticewrite">
      <div id="noticegroup" class="form-group">
        <label for="title">공지 사항</label>
        <input
          type="text"
          class="form-control"
          id="subject"
          ref="subject"
          placeholder="제목을 입력하세요"
          v-model="subject"
        />
      </div>
      <div id="noticegroup" class="form-group">
        <label for="content">내용</label>
        <textarea
          class="form-control"
          id="content"
          ref="content"
          placeholder="내용을 입력하세요"
          v-model="content"
        ></textarea>
      </div>
      <div class="text-center">
        <button class="btn btn-primary" @click="handler" style="border: 1px solid #172b4d; background-color:#172b4d; color:white;">공지사항 수정</button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import IndexHeader from "@/layouts/IndexHeader.vue";
import TitleImg from "@/layouts/TitleImg.vue";
export default {
  name: "NoticeUpdate",
  data() {
    return {
      subject: "",
      content: "",
      memberid: "",
      noticeno: ""
    };
  },
  components: {
    IndexHeader,
    TitleImg
  },
  created() {
    const params = new URL(document.location).searchParams;
    axios
      .get(`http://localhost:9999/ssafy/api/notice/${params.get("noticeno")}`)
      .then(({ data }) => {
        this.subject = data.subject;
        this.content = data.content;
        this.memberid = data.memberid;
        this.noticeno = data.noticeno;
      });
  },
  methods: {
    handler() {
      this.createHandler();
    },
    createHandler() {
      axios
        .put("http://localhost:9999/ssafy/api/notice/" + this.noticeno, {
          subject: this.subject,
          content: this.content,
          memberid: this.memberid,
          noticeno: this.noticeno
        })
        .then(() => {
          alert("수정된 공지사항이 등록되었습니다.");
          this.$router.push("/NoticeList");
        });
    }
  }
};
</script>
