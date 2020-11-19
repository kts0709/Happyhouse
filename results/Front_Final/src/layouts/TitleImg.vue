<template>
  <div class="img">
    <div class="content">
      <img v-bind:src="titleimg" />
    </div>
  </div>
</template>

<script>
export default {
  name: "TitleImg",
  data: function() {
    return {
      titleimg: "/img/title2.png"
    };
  }
};
</script>

<style>
.img:after {
  background-image: url(/img/mainpage1.png);
  top: 0;
  left: 0;
  position: absolute;
  background-size: 100%;
  opacity: 1.0 !important;
  filter: alpha(opacity=50);
  z-index: -1;
  content: "";
  width: 100%;
  height: 100%;
}
.img {
  position: relative;

  z-index: 1;
}
.maintitle {
  float: left;
}
</style>
