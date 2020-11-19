<template>
  <div>
    <index-header></index-header>
    <main-img  style="height:1400px;"></main-img>
  </div>
</template>

<script>
import IndexHeader from "@/layouts/IndexHeader.vue";
import MainImg from "@/layouts/MainImg.vue";

export default {
  name: "Index",

  components: {
    IndexHeader,
    MainImg
  }
};
</script>

<style>
</style>
