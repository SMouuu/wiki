<!--
 * @Author       : SMou
 * @Date         : 2022-04-01 15:10:18
 * @LastEditors  : SMou
 * @LastEditTime : 2022-04-07 01:28:30
 * @Description  : 请填写简介
-->
<template>
  <a-layout-header class="header">
    <div class="logo" />
    <a-menu theme="dark" mode="horizontal" :style="{ lineHeight: '64px' }">
      <a-menu-item key="/"><router-link to="/">首页</router-link></a-menu-item>

      <a-menu-item key="/admin/ebook"
        ><router-link to="/admin/ebook">电子书管理</router-link></a-menu-item
      >

      <a-menu-item key="/about"
        ><router-link to="/about">关于我们</router-link></a-menu-item
      >
    </a-menu>
  </a-layout-header>
</template>


<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
  name: "the-header",
});
</script>