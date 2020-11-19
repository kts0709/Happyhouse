<template>
  <div>
    <index-header></index-header>
    <title-img></title-img>
    <br />
    <h2>공지 사항 등록</h2>

    <div id="noticewrite">
      <!-- <div id="noticegroup" class="form-group">
        <label for="memberid">작성자</label>
        <input
          type="text"
          class="form-control"
          id="memberid"
          ref="memberid"
          placeholder="작성자 ID를 정확히 입력하세요"
          v-model="memberid"
        />
      </div> -->

      <div id="noticegroup" class="form-group">
        <label for="subject">공지 사항</label>
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
        <button class="btn btn-primary" @click="handler" style="border: 1px solid #172b4d; background-color:#172b4d; color:white;">공지 사항 등록</button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import IndexHeader from "@/layouts/IndexHeader.vue";
import TitleImg from "@/layouts/TitleImg.vue";
export default {
  name: "NoticeWrite",
  data() {
    return {
      subject: "",
      content: "",
      memberid: ""
    };
  },
  components: {
    IndexHeader,
    TitleImg
  },
  methods: {
    handler() {
      let err = true;
      let msg = "";
      !this.subject &&
        ((msg = "제목 입력해주세요"),
        (err = false),
        this.$refs.subject.focus());
      err &&
        !this.content &&
        ((msg = "내용 입력해주세요"),
        (err = false),
        this.$refs.content.focus());
      // err &&
      //   this.memberid != "admin" &&
      //   ((msg = "관리자만 공지사항을 등록할 수 있습니다."),
      //   (err = false),
      //   this.$refs.memberid.focus());
      if (!err) alert(msg);
      else this.createHandler();
    },
    createHandler() {
      axios
        .post("http://localhost:9999/ssafy/api/notice", {
          subject: this.subject,
          content: this.content,
          memberid: "admin"
        })
        .then(() => {
          alert("공지 사항이 등록되었습니다");
          this.$router.push("/NoticeList");
        });
    }
  }
};
</script>

<style>
#noticewrite {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 800px;
  margin: auto;
  padding: auto;
}
#noticegroup {
  display: flex;
  width: 720px;
  padding: 20px;
}

#noticegroup label {
  width: 100px;
  display: block;
  padding: 10px;
}
</style>