<template>
  <div>
    <index-header></index-header>

    <div class="img" style="height:1200px;">
      <div class="content">
        <div class="pt-lg-md">
          <div class="row justify-content-center" style="margin-top:300px;">
            <card
              type="secondary"
              shadow
              style="width:700px;"
              header-classes="bg-white pb-5"
              body-classes="px-lg-5 py-lg-5"
              class="border-0"
            >
              <div v-if="result === 'true'">
                <template>
                  <div class="text-muted text-center mb-3">
                    <big>Reset Your Password</big>
                    <br />
                    <br />
                    <form role="form">
                      <base-input
                        alternative
                        type="password"
                        class="mb-3"
                        id="memberpswd"
                        name="memberpswd"
                        placeholder="Write Your New PassWord."
                        ref="memberpswd"
                        v-model="memberpswd"
                        v-validate="'required|min:5|max:40'"
                        addon-left-icon="ni ni-lock-circle-open"
                      />
                      <div class="alert-danger" v-if="errors.has('memberpswd')">
                        "암호는 5자리 이상입니다."
                      </div>

                      <base-input
                        alternative
                        type="password"
                        class="mb-3"
                        id="pwdcheck"
                        name="pwdcheck"
                        placeholder="Write Your New Password Again."
                        ref="pwdcheck"
                        v-model="pwdcheck"
                        addon-left-icon="ni ni-lock-circle-open"
                      />
                    </form>

                    <div class="text-center">
                      <button class="btn btn-primary" @click="handler">
                        비밀번호변경
                      </button>
                    </div>
                  </div>
                </template>
              </div>
            </card>
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
  name: "MemberFindPasswordResult",
  data: function() {
    return {
      memberpswd: "",
      pwdcheck: "",
      result: "",
      id: ""
    };
  },
  components: {
    IndexHeader
  },
  created() {
    const params = new URL(document.location).searchParams;
    axios
      .get(
        `http://localhost:9999/ssafy/api/member/${params.get(
          "memberid"
        )}/${params.get("membername")}/${params.get("memberphone")}`
      )
      .then(() => {
        this.result = "true";
        this.id = params.get("memberid");
      })
      .catch(() => {
        alert("일치하는 정보가 없습니다.");
        this.$router.push("/MemberFindPassword");
      });
  },
  methods: {
    handler() {
      let err = true;
      let msg = "";
      !this.pwdcheck &&
        this.memberpswd === this.pwdcheck &&
        ((msg = "비밀번호를 확인해주세요"),
        (err = false),
        this.$refs.pwdcheck.focus());
      if (!err) alert(msg);
      else this.update();
    },
    update() {
      // alert(this.memberpswd);
      axios
        .put(`http://localhost:9999/ssafy/api/member/updatepswd/`, {
          id: this.id,
          password: this.memberpswd
        })
        .then(() => {
          alert("비밀번호 변경 성공");
          this.$router.push("/MemberLogin");
        })
        .catch(() => {
          alert("다시 시도해주세요");
        });
    }
  }
};
</script>

<style></style>
