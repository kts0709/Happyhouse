<template>
  <div>
    <index-header></index-header>
    <title-img></title-img>
    <br><br>
    <h2 class="text-center" style="font-family: 'Muli', sans-serif;">Member List</h2>
    <div v-if="items.length">
      <table id="list">
        <colgroup>
          <col :style="{ width: '25%' }" />
          <col :style="{ width: '25%' }" />
          <col :style="{ width: '50%' }" />
        </colgroup>
        <br>
        <tr >
          <th class="text-center" style="background-color:#172b4d; color:white;">회원 아이디</th>
          <th class="text-center" style="background-color:#172b4d; color:white;">회원 이름</th>
          <th class="text-center" style="background-color:#172b4d; color:white;">회원 핸드폰 번호</th>
        </tr>

        <tr v-for="(member, index) in items" :key="index + '_items'">
          <td>{{ member.memberId }}</td>
          <td>
            <router-link :to="'MemberDetail?memberid=' + member.memberId">
              {{
              member.memberName
              }}
            </router-link>
          </td>
          <td>{{ member.memberPhone }}</td>
        </tr>
      </table>
    </div>

    <div v-else class="text-center">회원정보가 없습니다.</div>
  </div>
</template>

<script>
import axios from "axios";
import IndexHeader from "@/layouts/IndexHeader.vue";
import TitleImg from "@/layouts/TitleImg.vue";
export default {
  name: "MemberList",
  data: function() {
    return {
      query: "",
      items: []
    };
  },
  components: {
    IndexHeader,
    TitleImg
  },
  created() {
    axios.get("http://localhost:9999/ssafy/api/member").then(({ data }) => {
      this.items = data;
    });
  }
};
</script>

<style>
#list {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 80%;
  margin: auto;
  padding: auto;
}

#list td,
#list th {
  border: 1px solid #ddd;
  padding: 8px;
}

#list tr:nth-child(even) {
  background-color: #f2f2f2;
}

#list tr:hover {
  background-color: #ddd;
}

#list th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #070844;
  color: white;
}
</style>