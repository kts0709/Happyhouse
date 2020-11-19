<template>
  <div class="img">
    <div class="content">
      <img v-bind:src="mainimg" />
    </div>
  </div>
</template>

<script>
export default {
  name: "MainImg",
  data: function() {
    return {
      mainimg: "/img/mainpage1.png"
    };
  }
};
</script>

<style>
img {
  width: 100%;
}
.img {
  position: relative;

  z-index: 1;
}
.maintitle {
  float: left;
}
</style>
