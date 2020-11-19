<template>
  <div>
    <index-header></index-header>
    <title-img></title-img>
    <br />
    <div align="center">
      <div class="col-lg-8" align="center">
        <h2>거래 목록 조회</h2>
        <table class="table table-borderless"></table>
        <table class="table table-borderless" id="searchform">
          <tr>
            <td align="center">
              <div class="btn-group" data-toggle="buttons">
                <label
                  class="btn btn-primary active"
                  style="border: 1px solid white; background-color:#172b4d; "
                >
                  <input type="checkbox"  id="1" value="1" autocomplete="off" v-model="types" />
                  아파트 매매
                </label>
                <label
                  class="btn btn-primary"
                  style="border: 1px solid white; background-color:#172b4d;"
                >
                  <input type="checkbox" id="2" value="2" autocomplete="off" v-model="types" />
                  아파트 전월세
                </label>
                <label
                  class="btn btn-primary"
                  style="border: 1px solid white; background-color:#172b4d; "
                >
                  <input type="checkbox" id="3" value="3" autocomplete="off" v-model="types" />
                  다세대,주택 매매
                </label>
                <label
                  class="btn btn-primary"
                  style="border: 1px solid white; background-color:#172b4d; "
                >
                  <input type="checkbox" id="4" value="4" autocomplete="off" v-model="types" />
                  다세대,주택 전월세
                </label>
              </div>
            </td>
          </tr>
          <tr>
            <td align="right">
              <div style="display:flex;justify-content: space-around; width:400px;" align="right">
                <select style="width:100px;" class="form-control" name="key" id="key" v-model="key">
                  
                   <!-- <option value="dong" selected>Select</option> -->
                  <option value="dong">동</option>
                  <option value="aptName">아파트이름</option>
                </select>&emsp;&emsp;
                <input
                  type="text"
                  style="width:200px;"
                  class="form-control"
                  placeholder="검색어 입력."
                  name="word"
                  id="word"
                  v-model="word"
                  @keyup.enter="handler"
                />

                <base-button
                  type="info"
                  style="border: 1px solid #172b4d; background-color:#172b4d; "
                  @click="handler"
                >검색</base-button>
              </div>
            </td>
          </tr>
        </table>

        <paging :list-array="items"></paging>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import Paging from "./HouseListTable.vue";
import IndexHeader from "@/layouts/IndexHeader.vue";
import TitleImg from "@/layouts/TitleImg.vue";
export default {
  name: "houselist",
  components: {
    Paging,
    IndexHeader,
    TitleImg
  },
  data() {
    return {
      types: [],
      key: "",
      word: "",
      items: [],
      Search: {}
    };
  },

  created() {
    axios.get("http://localhost:9999/ssafy/house/all").then(({ data }) => {
      this.items = data;
      this.types = [];
      this.word = "";
      this.key = "";
    });
  },
  methods: {
    handler() {
      this.createHandler();
    },
    createHandler() {
      axios
        .get(
          "http://localhost:9999/ssafy/house/search/" +
            this.key +
            "/" +
            this.word +
            "/" +
            this.types
        )
        .then(({ data }) => {
          this.items = data;
        })
        .catch(() => {
          alert("error");
        });
    }
  }
};
</script>