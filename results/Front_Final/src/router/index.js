import Vue from "vue";
import VueRouter from "vue-router";

import List from "@/layouts/List.vue";
import Save from "@/layouts/Save.vue";
import Detail from "@/layouts/Detail.vue";
import Delete from "@/layouts/Delete.vue";
import Update from "@/layouts/Update.vue";
import HouseList from "@/layouts/HouseList.vue";
import HouseDetail from "@/layouts/HouseDetail.vue";

import NoticeList from "@/layouts/NoticeList.vue";
import NoticeDetail from "@/layouts/NoticeDetail.vue";
import NoticeDelete from "@/layouts/NoticeDelete.vue";
import NoticeUpdate from "@/layouts/NoticeUpdate.vue";
import NoticeWrite from "@/layouts/NoticeWrite.vue";

import MemberLogin from "@/layouts/MemberLogin.vue";
import MemberJoin from "@/layouts/MemberJoin.vue";
import MemberDetail from "@/layouts/MemberDetail.vue";
import MemberUpdate from "@/layouts/MemberUpdate.vue";
import MemberDelete from "@/layouts/MemberDelete.vue";
import MemberFindPassword from "@/layouts/MemberFindPassword.vue";
import MemberFindPasswordResult from "@/layouts/MemberFindPasswordResult.vue";
import MainImg from "@/layouts/MainImg.vue";

import Index from "@/layouts/Index.vue";
import MemberList from "@/layouts/MemberList.vue";
import IndexHeader from "@/layouts/IndexHeader.vue";
import TitleImg from "@/layouts/TitleImg.vue";
import IndexFooter from "@/layouts/IndexFooter.vue";
Vue.use(VueRouter);

export default new VueRouter({
  mode: "history",
  routes: [
    {
      path: "/",
      name: "main",
      component: MemberLogin
    },
    {
      path: "/",
      name: "IndexFooter",
      component: IndexFooter
    },
    {
      path: "/Index",
      name: "Index",
      component: Index
    },
    {
      path: "/IndexHeader",
      name: "IndexHeader",
      component: IndexHeader
    },
    {
      path: "/TitleImg",
      name: "TitleImg",
      component: TitleImg
    },
    {
      path: "/MainImg",
      name: "MainImg",
      component: MainImg
    },
    {
      path: "/list",
      name: "list",
      component: List
    },
    {
      path: "/save",
      name: "save",
      component: Save
    },
    {
      path: "/detail",
      name: "detail",
      component: Detail
    },
    {
      path: "/delete",
      name: "delete",
      component: Delete
    },
    {
      path: "/update",
      name: "update",
      component: Update
    },
    {
      path: "/NoticeList",
      name: "NoticeList",
      component: NoticeList
    },
    {
      path: "/NoticeDetail",
      name: "NoticeDetail",
      component: NoticeDetail
    },
    {
      path: "/NoticeDelete",
      name: "NoticeDelete",
      component: NoticeDelete
    },
    {
      path: "/NoticeUpdate",
      name: "NoticeUpdate",
      component: NoticeUpdate
    },
    {
      path: "/NoticeWrite",
      name: "NoticeWrite",
      component: NoticeWrite
    },
    {
      path: "/MemberJoin",
      name: "MemberJoin",
      component: MemberJoin
    },
    {
      path: "/MemberLogin",
      name: "MemberLogin",
      component: MemberLogin
    },
    {
      path: "/MemberDetail",
      name: "MemberDetail",
      component: MemberDetail
    },
    {
      path: "/MemberUpdate",
      name: "MemberUpdate",
      component: MemberUpdate
    },
    {
      path: "/MemberDelete",
      name: "MemberDelete",
      component: MemberDelete
    },
    {
      path: "/MemberFindPassword",
      name: "MemberFindPassword",
      component: MemberFindPassword
    },
    {
      path: "/MemberFindPasswordResult",
      name: "MemberFindPasswordResult",
      component: MemberFindPasswordResult
    },
    {
      path: "/MemberList",
      name: "MemberList",
      component: MemberList
    },
    {
      path: "/houselist",
      name: "houselist",
      component: HouseList
    },
    {
      path: "/housedetail",
      name: "housedetail",
      component: HouseDetail
    }
  ]
});