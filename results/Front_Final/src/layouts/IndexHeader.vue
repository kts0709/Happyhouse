<template>
  <div style="position: relative;" id="checkid">
    <base-nav type="default" effect="dark" expand>
       <router-link :to="'/Index'" class="navbar-brand" style="font-family: 'Francois One', sans-serif; font-size:1.5em; position: relative; right: 300px;">Happy House</router-link>

      <ul class="navbar-nav flex-row mr-auto ml-4 d-none d-md-flex" style=" position: relative; right: 300px;">
        <li class="nav-item">
             <router-link :to="'/HouseList'" class="nav-link nav-link-icon">Find My House</router-link>

        </li>
        <li class="nav-item">
            <router-link :to="'/NoticeList'" class="nav-link nav-link-icon">Notice</router-link>
     
        </li>
        <li class="nav-item">
         <router-link :to="'/List'" class="nav-link nav-link-icon">Q & A</router-link>
        </li>
      </ul>
      <ul class="navbar-nav ml-lg-auto" style=" position: relative; left: 300px;">
        <template v-if="!memberid">
          <li class="nav-item">
            <a class="nav-link nav-link-icon" href="/MemberLogin">Sign In</a>
          </li>
          <li class="nav-item">
            <a class="nav-link nav-link-icon" href="/MemberJoin">Sign Up</a>
          </li>
        </template>

        <template v-else>
          <li class="nav-item">
            <strong>
              <router-link
                :to="'MemberDetail?memberid=' + memberid"
                class="nav-link nav-link-icon"
                >{{ memberid}}</router-link
              >
            </strong>
          </li>
          <li>
            <p style="color:white; margin-top: 13px;margin-right: 13px;">
              님 환영합니다.
            </p>
          </li>

          <li class="nav-item">
            <router-link
              :to="'MemberDetail?memberid=' + memberid"
              class="nav-link nav-link-icon"
              >My Info</router-link
            >
          </li>
          <li class="nav-item">
            <button
              class="btn btn-link"
              @click="logout"
              style="color:white;margin-top: 5px; padding-left:0px;"
            >
              Logout
            </button>
          </li>

          <template v-if="memberid == 'admin'">
            <li class="nav-item">
              <router-link :to="'/MemberList'" class="nav-link nav-link-icon"
                >Member List</router-link
              >&emsp;
            </li>
          </template>
        </template>
      </ul>
    </base-nav>
    <!-- <img v-bind:src="mainimg"/> -->
  </div>
</template>

<script>
import axios from "axios";
import BaseNav from "@/components/BaseNav.vue";

export default {
  name: "IndexHeader",
  data: function() {
    return {
      memberid: ""
    };
  },
  components: {
    BaseNav
  },
  async created() {
    this.memberid = await this.$session.get("memberid");
  },
  methods: {
    logout() {
      axios
        .post("http://localhost:9999/ssafy/api/member/logout", {})
        .then(() => {
          this.$session.remove("memberid");
          this.memberid = "";
          alert("로그아웃 성공");
          this.$router.push("/Index");
        });
    }
  }
};
</script>

<style>
#app {
  padding: 0px;
  margin: 0px;
}
#checkid {
  height: 150%;
  margin: 0%;
  padding: 0%;
}
</style>