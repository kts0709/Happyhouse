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
                  <!-- <div class="text-muted text-center mb-3">
                    <small>Your Info</small>
                  </div> -->

                  <table class="type10">
                    <thead>
                      <tr>
                        <th scope="cols" style="background-color:#172b4d; color:white;"></th>
                        <th scope="cols" style="background-color:#172b4d; color:white;">Your Info</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <th scope="row">ID</th>
                        <td>{{ Member.memberId }}</td>
                      </tr>
                      <tr>
                        <th scope="row" class="even">Name</th>
                        <td class="even">{{ Member.memberName }}</td>
                      </tr>
                      <tr>
                        <th scope="row">Tel.</th>
                        <td>{{ Member.memberPhone }}</td>
                      </tr>
                      <tr>
                        <th scope="row" class="even">Age</th>
                        <td class="even">{{ Member.memberAge }}</td>
                      </tr>
                    </tbody>
                  </table>

                  <div class="text-center">
                    <router-link :to="'/MemberUpdate?memberid=' + Member.memberId">
                      <base-button type="secondary" class="btn button5" style="margin-right: 20px; border: 1px solid #172b4d; background-color:#172b4d; color:white;">정보 변경</base-button>
                    </router-link>

                    <!-- <router-link :to="'/MemberDelete?memberid=' + Member.memberId"> -->
                      <button class="btn button3" style="background-color:red; color:white;" @click="removeCheck">회원 탈퇴</button>
                    <!-- </router-link> -->
                  </div>
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
import axios from "axios";
export default {
  name: "MemberDetail",
  data: function() {
    return {
      Member: {}
    };
  },
  components: {
    IndexHeader
  },
  created() {
    const params = new URL(document.location).searchParams;
    axios
      .get(`http://localhost:9999/ssafy/api/member/${params.get("memberid")}`)
      .then(({ data }) => {
        this.Member = data;
      });
  },
  methods: {
    removeCheck() {
      if (confirm("정말 탈퇴하시겠습니까??") == true){    //확인
        this.$session.remove("memberid");
        this.memberid = "";
        this.$router.push("/MemberDelete?memberid="+this.Member.memberId);
      }else{   //취소
        return false;
      }
    }
  }
};
</script>

<style>
table.type10 {
  border-collapse: collapse;
  text-align: left;
  line-height: 1.5;
  border-top: 1px solid #ccc;
  border-bottom: 1px solid #ccc;
  margin: 20px 10px;
}
table.type10 thead th {
  width: 150px;
  padding: 10px;
  font-weight: bold;
  vertical-align: top;
  color: #fff;
  background: #070844;
  margin: 20px 10px;
}
table.type10 tbody th {
  width: 150px;
  padding: 10px;
}
table.type10 td {
  width: 350px;
  padding: 10px;
  vertical-align: top;
}
table.type10 .even {
  background: #ebecf3;
}
.button5 {
  background-color: white;
  color: black;
  border: 2px solid #555555;
}

.button5:hover {
  background-color: #555555;
  color: white;
}
.button3 {
  background-color: white;
  color: black;
  border: 2px solid #f44336;
}

.button3:hover {
  background-color: #f44336;
  color: white;
}
</style>