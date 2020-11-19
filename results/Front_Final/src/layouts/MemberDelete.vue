<template>
  <div>
    <index-header></index-header>
    <title-img></title-img>
    <br />
    <h5>탈퇴가 완료 되었습니다.</h5>
    <h2>이용해 주셔서 감사합니다.</h2>
  </div>
</template>


<script>
import axios from "axios";
import IndexHeader from "@/layouts/IndexHeader.vue";
import TitleImg from "@/layouts/TitleImg.vue";
export default {
  name: "MemberDelete",
  created() {
    const params = new URL(document.location).searchParams;
    axios
      .delete(
        `http://localhost:9999/ssafy/api/member/${params.get("memberid")}`
      )
      .then(({ data }) => {
        let msg = "삭제시 문제가 발생했습니다.";
        if (data === "success") {
          msg = "삭제 완료되었습니다.";
          this.$session.remove("memberid");
        }
        alert(msg);
        this.$router.push("/Index");
      });
  },
  components: {
    IndexHeader,
    TitleImg
  }
};
</script>

<style></style>
