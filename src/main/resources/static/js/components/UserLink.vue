<template>
  <router-link
      :to="`/user/${userId}`"
  >
    <v-avatar
        v-if="user && user.userpic"
        size="48"
    >
      <img
          :src="user.userpic"
          :alt="user.name"
      >
    </v-avatar>

    <v-avatar
        v-else
        size="48"
        color="indigo"
    >
      <v-icon dark>account_circle</v-icon>
    </v-avatar>
    <span> {{ userName }}</span>
  </router-link>
</template>
<script>
  import {mapState} from "vuex";

  export default {
    name: 'UserLink',
    props: ['user'],
    computed: {
      ...mapState(['profile']),
      userName() {
        return this.user ? this.user.name : 'unknown'
      },
      userId() {
        return this.user ? String(this.user.id) : 'null'
      }
    },
  }
</script>

<style scoped>

</style>