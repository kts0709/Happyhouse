<template>
  <div>
    <table class="table table-active" style="background-color:white;">
      <tbody v-for="houseDeal in paginatedData" :key="houseDeal.no">
        <tr class="table-info">
          <td colspan="2" style="background-color:#172b4d; color:white;">NO. {{ houseDeal.no }}</td>
        </tr>
        <tr>
          <td class="table-danger" style="background-color:white; color:#172b4d;">
            <router-link
              :to="'housedetail?no=' + houseDeal.no"
              style="color:#172b4d;"
            >{{ houseDeal.aptName }}</router-link>
          </td>
          <td
            class="table-danger"
            align="right"
            style="background-color:#172b4d; color:white;"
          >동 : {{ houseDeal.dong }}</td>
          <td
            class="table-danger"
            align="right"
            style="background-color:#172b4d; color:white;"
          >거래금액 : {{ houseDeal.dealAmount }}</td>
          <td
            class="table-danger"
            align="right"
            style="background-color:#172b4d; color:white;"
          >타입 : {{ houseDeal.type }}</td>
        </tr>
        <br />
      </tbody>
    </table>
    <div class="btn-cover">
      <button :disabled="pageNum === 0" @click="prevPage" class="page-btn">이전</button>
      <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }} 페이지</span>
      <button :disabled="pageNum >= pageCount - 1" @click="nextPage" class="page-btn">다음</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "Paging",
  data() {
    return {
      pageNum: 0
    };
  },
  props: {
    listArray: {
      type: Array,
      required: true
    },
    pageSize: {
      type: Number,
      required: false,
      default: 10
    }
  },
  methods: {
    nextPage() {
      this.pageNum += 1;
    },
    prevPage() {
      this.pageNum -= 1;
    }
  },
  computed: {
    pageCount() {
      let listLeng = this.listArray.length,
        listSize = this.pageSize,
        page = Math.floor(listLeng / listSize);
      if (listLeng % listSize > 0) page += 1;

      return page;
    },
    paginatedData() {
      const start = this.pageNum * this.pageSize,
        end = start + this.pageSize;
      return this.listArray.slice(start, end);
    }
  }
};
</script>