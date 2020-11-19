<template>
  <div>
    <index-header></index-header>
    <title-img></title-img>
    <br />
    <h2>공지 사항이 삭제 되었습니다.</h2>
  </div>
</template>

<script>
import axios from "axios";
import IndexHeader from "@/layouts/IndexHeader.vue";
import TitleImg from "@/layouts/TitleImg.vue";
export default {
  name: "NoticeDelete",
  created() {
    const params = new URL(document.location).searchParams;
    axios
      .delete(
        `http://localhost:9999/ssafy/api/notice/${params.get("noticeno")}`
      )
      .then(({ data }) => {
        let msg = "삭제시 문제가 발생했습니다.";
        if (data === "success") {
          msg = "삭제 완료되었습니다.";
        }
        alert(msg);
        this.$router.push("/NoticeList");
      });
  },
  components: {
    IndexHeader,
    TitleImg
  }
};
</script>

<style></style>
