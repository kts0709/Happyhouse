<template>
  <div>
    <index-header></index-header>
    <div class="img" style="height:1000px;">
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
                    <small>Forget My Password...?</small>
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
                    />

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

                    <div id="tel" class="custom-control-inline">
                      <select
                        class="form-control"
                        id="memberphone1"
                        name="memberphone1"
                        ref="memberphone1"
                        v-model="memberphone1"
                      >
                        <option value selected>-- select --</option>
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
                      />-
                      <base-input
                        alternative
                        type="text"
                        class="mb-3"
                        id="memberphone3"
                        name="memberphone3"
                        placeholder="XXXX"
                        ref="memberphone3"
                        v-model="memberphone3"
                      />
                    </div>
                    <div class="text-center">
                      <router-link
                        :to="'/MemberFindPasswordResult?memberid=' +
              this.memberid +
              '&membername=' +
              this.membername +
              '&memberphone=' +
              this.memberphone1 +
              '-' +
              this.memberphone2 +
              '-' +
              this.memberphone3"
                      >
                        <base-button type="warning">>Find</base-button>
                      </router-link>
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
import IndexHeader from "@/layouts/IndexHeader.vue";
import BaseButton from "@/components/BaseButton.vue";
import BaseInput from "@/components/BaseInput.vue";
import Card from "@/components/Card.vue";
export default {
  name: "MemberFindPassword",
  data() {
    return {
      memberid: "",
      membername: "",
      memberphone: "",
      memberphone1: "",
      memberphone2: "",
      memberphone3: "",
      memberpswd: "****"
    };
  },
  components: {
    IndexHeader,
    BaseButton,
    BaseInput,
    Card
  },
  created() {
    this.memberphone =
      this.memberphone1 + "-" + this.memberphone2 + "-" + this.memberphone3;
  }
};
</script>

<style></style>
