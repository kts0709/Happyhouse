import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import VueSession from "vue-session";
import Argon from "@/plugins/argon-kit";
import VeeValidate from "vee-validate";

// import store from "./store/store";

Vue.config.productionTip = false;

new Vue({
  router,
  render: h => h(App)
}).$mount("#app");

var sessionOptions = {
  persist: true
};

Vue.use(VueSession, sessionOptions);
Vue.use(Argon);
Vue.use(VeeValidate);
