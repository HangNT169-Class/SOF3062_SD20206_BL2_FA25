<template>
  <table>
    <thead></thead>
    <tbody>
      <!-- ... v-for de hien thi danh sach list -->
    </tbody>
  </table>
</template>

<script setup>
import { getCategories } from "@/service/CategoryService";
import { onMounted, ref } from "vue";

const list = ref([]);
const fetchData = async () => {
  list.value = await getCategories();
};
// lay gia tri tu API khi component duoc khoi tao => onMounted
onMounted(fetchData);
</script>

<style scoped></style>
