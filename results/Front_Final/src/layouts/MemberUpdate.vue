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
                    <small>Update Your Info</small>
                  </div>
         <badge type="default" style="float:left;margin-bottom:5px;">Name</badge>
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
                    />
                             <badge type="default" style="float:left;margin-bottom:5px;">ID</badge>
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
                      readonly="readonly"
                    />
                    <badge type="default" style="float:left;margin-bottom:5px;">Password</badge>
                    <base-input
                      alternative
                      type="password"
                      class="mb-3"
                      id="memberpswd"
                      name="memberpswd"
                      ref="memberpswd"
                      v-model="memberpswd"
                      addon-left-icon="ni ni-lock-circle-open"
                    />
                    <badge type="default" style="float:left;margin-bottom:5px;">Password Check</badge>
                    <base-input
                      alternative
                      type="password"
                      class="mb-3"
                      id="pwdcheck"
                      name="pwdcheck"
                      ref="pwdcheck"
                      v-model="pwdcheck"
                      addon-left-icon="ni ni-lock-circle-open"
                    />
         <badge type="default" style="float:left;margin-bottom:5px;">Phone</badge>
                    <base-input
                      alternative
                      type="text"
                      class="mb-3"
                      id="memberphone"
                      name="memberphone"
                      placeholder="memberphone"
                      ref="memberphone"
                      v-model="memberphone"
                      addon-left-icon="ni ni-lock-circle-open"
                    />
         <badge type="default" style="float:left;margin-bottom:5px;">Age</badge>
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
                    />
                    <div class="text-center">
                      <base-button type="primary" class="my-4" @click="handler">>Update</base-button>
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
export default {
  name: "MemberUpdate",
  data() {
    return {
      memberid: "",
      membername: "",
      memberphone: "",
      memberpswd: "",
      memberage: ""
    };
  },
  created() {
    const params = new URL(document.location).searchParams;
    axios
      .get(`http://localhost:9999/ssafy/api/member/${params.get("memberid")}`)
      .then(({ data }) => {
        this.memberid = data.memberId;
        this.membername = data.memberName;
        this.memberphone = data.memberPhone;
        this.memberpswd = data.memberPswd;
        this.memberage = data.memberAge;
      });
  },
  components: {
    IndexHeader
  },
  methods: {
    handler() {
      let err = true;
      let msg = "비밀번호와 비밀번호 확인이 일치하지 않습니다.";
      !this.membername &&
        ((msg = "이름을 입력해주세요"),
        (err = false),
        this.$refs.membername.focus());
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
        !this.memberphone &&
        ((msg = "핸드폰을 입력해주세요"),
        (err = false),
        this.$refs.memberphone.focus());
      err &&
        !this.memberage &&
        ((msg = "나이을 입력해주세요"),
        (err = false),
        this.$refs.memberage.focus());
      if (!err || this.memberpswd !== this.pwdcheck) {
        alert(msg);
      } else this.createHandler();
    },
    createHandler() {
      axios
        .put("http://localhost:9999/ssafy/api/member/" + this.memberid, {
          memberId: this.memberid,
          memberName: this.membername,
          memberPhone: this.memberphone,
          memberPswd: this.memberpswd,
          memberAge: this.memberage
        })
        .then(() => {
          alert("회원 정보 수정을 완료하였습니다");
          this.$router.push("/MemberDetail?memberid=" + this.memberid);
        });
    }
  }
};
</script>

