<template>
  <div>
    <index-header></index-header>
    <title-img></title-img>
    <br />
    <h2>' Happy House Information '</h2>
    <br />
    <br />
    <router-link :to="'houselist'">
      <button class="btn btn-primary" style="border: 1px solid #172b4d; background-color:#172b4d; ">Back to previous page</button>
    </router-link>
    <br />
    <br />
    <div align="center">
      <div class="row" align="center">
        <div class="col-lg-6">
          <h3>거래 매물 상세 정보</h3>
          <br />
          <table class="table table-active" style="margin:0px; width:80%">
            <tbody>
              <tr class="table-info">
                <td align="left" style="background-color:#172b4d; color:white;">주택명</td>
                <td style="background-color:#172b4d; color:white;">{{ item.aptName }}</td>
              </tr>
              <tr class="table-info">
                <td align="left" style="background-color:white; color:#172b4d;">거래금액</td>
                <td style="background-color:white; color:#172b4d;">{{ item.dealAmount }}</td>
              </tr>
              <tr class="table-info">
                <td align="left" style="background-color:#172b4d; color:white;">월세금액</td>
                <td style="background-color:#172b4d; color:white;">{{ item.rentMoney }}</td>
              </tr>
              <tr class="table-info">
                <td align="left" style="background-color:white; color:#172b4d;">건축연도</td>
                <td style="background-color:white; color:#172b4d;">{{ item.buildYear }}</td>
              </tr>
              <tr class="table-info">
                <td align="left" style="background-color:#172b4d; color:white;">전용면적</td>
                <td style="background-color:#172b4d; color:white;">{{ item.area }}</td>
              </tr>
              <tr class="table-info">
                <td align="left" style="background-color:white; color:#172b4d;">거래일</td>
                <td style="background-color:white; color:#172b4d;">{{ item.dealDay }}</td>
              </tr>
              <tr class="table-info">
                <td align="left" style="background-color:#172b4d; color:white;">법정동</td>
                <td style="background-color:#172b4d; color:white;">{{ item.dong }}</td>
              </tr>
              <tr class="table-info">
                <td align="left" style="background-color:white; color:#172b4d;">지번</td>
                <td style="background-color:white; color:#172b4d;">{{ item.jibun }}</td>
              </tr>
            </tbody>
          </table>
        </div>

        <div class="col-lg-6">
          <h3>거래 매물 위치</h3>
          <br />
          <img :src="staticMap" style="width:70%;" />
        </div>
        <hr />
        <div class="col-lg-6">
          <hr />
          <br />
          <h3>주변 학군 정보</h3>
          <div v-if="schoolitems.length">
            <table class="table table-bordered" style="width:100%; float:left; margin:30px;">
              <colgroup>
                <col :style="{ width: '15%' }" />
                <col :style="{ width: '10%' }" />
                <col :style="{ width: '45%' }" />
                <col :style="{ width: '30%' }" />
              </colgroup>
              <tr>
                <td style="background-color:#172b4d; color:white;" align="center" width="25%">학교명</td>
                <td style="background-color:#172b4d; color:white;" align="center" width="15%">구분</td>
                <td style="background-color:#172b4d; color:white;" align="center" width="0%">주소</td>
                <td style="background-color:#172b4d; color:white;" align="center" width="35%">>전화 번호</td>
              </tr>
              <tr v-for="(school, index) in schoolitems" :key="index + '_schoolitems'">
                <td align="center">{{ school.name }}</td>
                <td align="center">{{ school.rate }}</td>
                <td align="center">{{ school.address }}</td>
                <td align="center">{{ school.contact }}</td>
              </tr>
            </table>
          </div>
          <div v-else class="text-center">아직 업데이트 되지 않았습니다.</div>
        </div>

        <hr />
        <div class="col-lg-6">
          <hr />
          <div class="container">
            <br />
            <div>
              <h3 style="padding-left:150px;">유사 매물</h3>
            </div>

            <div v-if="similaritems.length">
              <table
                class="table table-bordered table-condensed"
                style="width:80%; float:right; margin:30px;"
              >
                <colgroup>
                  <col :style="{ width: '15%' }" />
                  <col :style="{ width: '15%' }" />
                  <col :style="{ width: '50%' }" />
                  <col :style="{ width: '20%' }" />
                </colgroup>
                <tr>
                  <td style="background-color:#172b4d; color:white;" align="center">지번</td>
                  <td style="background-color:#172b4d; color:white;" align="center">전용면적</td>
                  <td style="background-color:#172b4d; color:white;" align="center">주택명</td>
                  <td style="background-color:#172b4d; color:white;" align="center">거래금액</td>
                </tr>
                <tr v-for="deal in similaritems" :key="deal.no">
                  <td align="center">{{ deal.dong }}</td>
                  <td align="center">{{ deal.area }}</td>
                  <td align="center">
                    <a v-bind:href="link + deal.no">{{ deal.aptName }}</a>
                  </td>
                  <td align="center">{{ deal.dealAmount }}</td>
                </tr>
              </table>
            </div>
            <div v-else class="text-center">유사한 거래가 없습니다.</div>
          </div>
        </div>
      </div>
      <router-link :to="'houselist'">
        <button class="btn btn-primary"  style="border: 1px solid #172b4d; background-color:#172b4d; ">Back to previous page</button>
      </router-link>
      <br />
      <br />
      <br />
      <br />
    </div>
  </div>
</template>

<script>
import axios from "axios";
import IndexHeader from "@/layouts/IndexHeader.vue";
import TitleImg from "@/layouts/TitleImg.vue";
export default {
  name: "housedetail",
  data() {
    return {
      item: "",
      staticMap: "",
      lng: "",
      lat: "",
      houseitem: "",
      schoolitems: [],
      similaritems: [],
      link: "housedetail?no=",
      //  memberid:""
    };
  },
  components: {
    IndexHeader,
    TitleImg
  },
  created() {
        // this.memberid = this.$session.get("memberid");
    const params = new URL(document.location).searchParams;
    axios
      .get(`http://localhost:9999/ssafy/house/details/${params.get("no")}`)
      .then(data => {
        this.item = data.data;
        this.houseitem = data.data;
        axios
          .get(
            `http://localhost:9999/ssafy/house/lnglat/` +
              this.item.dong +
              "/" +
              this.item.aptName
          )
          .then(datas => {
            this.lng = datas.data[0];
            this.lat = datas.data[1];
            this.staticMap =
              "https://naveropenapi.apigw.ntruss.com/map-static/v2/raster-cors?w=580&h=580&markers=type:d|size:mid|pos:" +
              this.lng +
              " " +
              this.lat +
              "&X-NCP-APIGW-API-KEY-ID=4lljlwfqsj";
          });
        axios
          .get(
            `http://localhost:9999/ssafy/house/school/` + this.houseitem.dong
          )
          .then(({ data }) => {
            this.schoolitems = data;
          });
        axios
          .get(
            `http://localhost:9999/ssafy/house/` +
              this.houseitem.type +
              `/` +
              this.houseitem.dong +
              `/` +
              this.houseitem.area +
              `/` +
              this.houseitem.no
          )
          .then(({ data }) => {
            this.similaritems = data;
          });
      });
  },
  updated() {
    this.$router.push();
  }
};
</script>

<style></style>