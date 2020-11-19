<template>
  <div>
    <index-header></index-header>
    <!-- <member-login></member-login> -->
    <!-- <main-img></main-img> -->
    <div class="img" style="height:1400px;">
      <div class="content">
        <div class="container pt-lg-md">
          <div class="row justify-content-center" style="margin-top:300px;">
            <div class="col-lg-5">
              <card
                type="secondary"
                shadow
                header-classes="bg-white pb-5"
                body-classes="px-lg-5 py-lg-5"
                class="border-0"
              >
                <template>
                  <div class="text-muted text-center mb-3">
                    <small>Sign in with</small>
                  </div>

                  <form role="form">
                    <base-input
                      alternative
                      type="text"
                      class="mb-3"
                      id="memberid"
                      name="memberid"
                      placeholder="ID"
                      ref="memberid"
                      v-model="memberid"
                      addon-left-icon="ni ni-email-83"
                    ></base-input>

                    <base-input
                      alternative
                      type="password"
                      class="mb-3"
                      id="memberpswd"
                      name="memberpswd"
                      placeholder="Password"
                      ref="memberpswd"
                      v-model="memberpswd"
                      addon-left-icon="ni ni-lock-circle-open"
                    ></base-input>

                    <!-- <base-checkbox>Remember me</base-checkbox> -->
                    <div class="text-center">
                      <base-button type="primary" class="my-4" @click="handler"
                        >>Sign In</base-button
                      >
                    </div>
                  </form>
                </template>

                <div class="row mt-3">
                  <div class="col-6">
                    <a href="/MemberFindPassword" class="text-light">
                      <small>Forgot password?</small>
                    </a>
                  </div>
                  <div class="col-6 text-right">
                    <a href="/MemberJoin" class="text-light">
                      <small>Create new account</small>
                    </a>
                  </div>
                </div>
              </card>
            </div>
          </div>
        </div>
      </div>
      <div class="img-cover"></div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import IndexHeader from "@/layouts/IndexHeader.vue";
import BaseButton from "@/components/BaseButton.vue";
import BaseInput from "@/components/BaseInput.vue";
import Card from "@/components/Card.vue";
// import MainImg from "@/layouts/MainImg.vue";
export default {
  name: "MemberLogin",
  data() {
    return {
      memberid: "",
      memberpswd: ""
    };
  },
  components: {
    IndexHeader,
    BaseButton,
    BaseInput,
    Card
    // MainImg
  },
  methods: {
    handler() {
      let err = true;
      let msg = "";
      !this.memberid &&
        ((msg = "아이디를 입력해주세요"),
        (err = false),
        this.$refs.memberid.focus());
      err &&
        !this.memberpswd &&
        ((msg = "비밀번호를 입력해주세요"),
        (err = false),
        this.$refs.memberpswd.focus());
      if (!err) alert(msg);
      else {
        this.createHandler();
      }
    },
    createHandler() {
      axios
        .post("http://localhost:9999/ssafy/api/member/login", {
          memberId: this.memberid,
          memberPswd: this.memberpswd
        })
        .then(() => {
          this.$router.push("/Index");
          this.$session.set("memberid", this.memberid);
          console.log(this.$session.get("memberid"));
          alert("로그인 성공");
        })
        .catch(() => {
          alert("아이디와 비밀번호를 확인해주세요!");
        });
    }
  }
};
</script>

<style>
/* .img {
  position: relative;
  background-image: url(/img/mainpage.png);
  height: 100%;
  background-size: cover;
} */
</style>