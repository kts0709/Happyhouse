<template>
  <div>
    <index-header></index-header>

    <div class="img" style="height:1200px;">
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
                    <small>Sign Up Our Site</small>
                  </div>

                  <form role="form">
                    <base-input
                      alternative
                      type="text"
                      class="mb-3"
                      id="membername"
                      name="membername"
                      placeholder="Name"
                      ref="membername"
                      v-model="membername"
                      addon-left-icon="ni ni-caps-small"
                      v-validate="'required|min:2|max:20'"
                    />
                    <!-- <div class="alert-danger" v-if="errors.has('membername')">
        "이름은 최소 2글자 입니다."
                    </div>-->

                    <base-input
                      alternative
                      type="text"
                      class="mb-3"
                      id="memberid"
                      name="memberid"
                      placeholder="ID"
                      ref="memberid"
                      v-model="memberid"
                      v-validate="'required|email|max:50'"
                      addon-left-icon="ni ni-email-83"
                    ></base-input>
                    <!-- <div class="alert-danger" v-if="errors.has('memberid')">
        "올바른 이메일 형태를 입력하세요"
                    </div>-->

                    <base-input
                      alternative
                      type="password"
                      class="mb-3"
                      id="memberpswd"
                      name="memberpswd"
                      placeholder="Password (5자리 이상)"
                      ref="memberpswd"
                      v-model="memberpswd"
                      v-validate="'required|min:6|max:40'"
                      addon-left-icon="ni ni-lock-circle-open"
                    ></base-input>
                    <!-- <div class="alert-danger" v-if="errors.has('memberpswd')">
        "암호는 6자리 이상입니다."
                    </div>-->

                    <base-input
                      alternative
                      type="password"
                      class="mb-3"
                      id="pwdcheck"
                      name="pwdcheck"
                      placeholder="Check Password"
                      ref="pwdcheck"
                      v-model="pwdcheck"
                      addon-left-icon="ni ni-lock-circle-open"
                    ></base-input>

                    <div id="tel" class="custom-control-inline">
                      <select
                        class="mb-3"
                        id="memberphone1"
                        name="memberphone1"
                        ref="memberphone1"
                        v-model="memberphone1"
                      >
                        <option value>-- Phone --</option>
                        <option value="010">010</option>
                        <option value="02">02</option>
                        <option value="031">031</option>
                        <option value="032">032</option>
                        <option value="041">041</option>
                        <option value="051">051</option>
                        <option value="061">061</option>
                      </select>-
                      <base-input
                        alternative
                        type="text"
                        class="mb-3"
                        id="memberphone2"
                        name="memberphone2"
                        placeholder="XXXX"
                        ref="memberphone2"
                        v-model="memberphone2"
                      ></base-input>-
                      <base-input
                        alternative
                        type="text"
                        class="mb-3"
                        id="memberphone3"
                        name="memberphone3"
                        placeholder="XXXX"
                        ref="memberphone3"
                        v-model="memberphone3"
                      ></base-input>
                    </div>

                    <base-input
                      alternative
                      type="text"
                      class="mb-3"
                      id="memberage"
                      name="memberage"
                      placeholder="Age"
                      min="0"
                      max="100"
                      ref="memberage"
                      v-model="memberage"
                      addon-left-icon="ni ni-caps-small"
                    ></base-input>
                    <div class="text-center">
                      <a class="btn btn-primary" @click="handler" style="color:white;">>Sign Up</a>
                    </div>
                  </form>
                </template>
              </card>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

import IndexHeader from "@/layouts/IndexHeader.vue";

import BaseInput from "@/components/BaseInput.vue";
import Card from "@/components/Card.vue";

export default {
  name: "MemberJoin",
  data() {
    return {
      membername: "",
      memberid: "",
      memberpswd: "",
      pwdcheck: "",
      memberphone1: "",
      memberphone2: "",
      memberphone3: "",
      memberage: ""
    };
  },
  components: {
    IndexHeader,

    BaseInput,
    Card
  },
  methods: {
    handler() {
      let err = true;
      let msg = "";
      !this.membername &&
        ((msg = "이름을 입력해주세요"),
        (err = false),
        this.$refs.membername.focus());
      err &&
        !this.memberid &&
        ((msg = "아이디를 입력해주세요"),
        (err = false),
        this.$refs.memberid.focus());
      err &&
        !this.memberpswd &&
        ((msg = "비밀번호를 입력해주세요"),
        (err = false),
        this.$refs.memberpswd.focus());
      err &&
        !this.pwdcheck &&
        this.memberpswd === this.pwdcheck &&
        ((msg = "비밀번호를 확인해주세요"),
        (err = false),
        this.$refs.pwdcheck.focus());
      err &&
        !this.memberphone1 &&
        !this.memberphone2 &&
        !this.memberphone3 &&
        ((msg = "핸드폰을 입력해주세요"),
        (err = false),
        this.$refs.memberphone2.focus());
      err &&
        !this.memberage &&
        ((msg = "나이을 입력해주세요"),
        (err = false),
        this.$refs.memberage.focus());
      if (!err) alert(msg);
      else this.createHandler();
    },
    createHandler() {
      axios
        .post("http://localhost:9999/ssafy/api/member/join", {
          memberName: this.membername,
          memberId: this.memberid,
          memberPswd: this.memberpswd,
          memberPhone:
            this.memberphone1 +
            "-" +
            this.memberphone2 +
            "-" +
            this.memberphone3,
          memberAge: this.memberage
        })
        .then(() => {
          alert("가입이 완료되었습니다");
          this.$router.push("/MemberLogin");
        })
        .catch(() => {
          alert("이미 가입된 정보입니다.");
        });
    }
  }
};
</script>

