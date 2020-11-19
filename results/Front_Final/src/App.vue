<template>
  <div id="app">
    <!-- <router-link to="/">HappyHouse</router-link> -->
    <router-view></router-view>
    <index-footer></index-footer>
  </div>
</template>

<script>
import IndexFooter from "@/layouts/IndexFooter.vue";
export default {
  name: "App",
   components: {
IndexFooter
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;

}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
