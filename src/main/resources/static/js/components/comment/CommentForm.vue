<template>
  <v-layout row class="px-3">
    <v-text-field
        label="Add comment"
        placeholder="Write something"
        v-model="text"
    />
    <v-btn @click="save">
      Add
    </v-btn>
  </v-layout>
</template>

<script>
import { mapActions } from 'vuex'
export default {
  name: 'CommentForm',
  props: ['messageId'],
  data() {
    return {
      text: ''
    }
  },
  methods: {
    ...mapActions(['addCommentAction']),
    async save() {
      const comment = {
        text: this.text,
        message: {
          id: this.messageId
        }
      }
      await this.addCommentAction(comment)
      this.text = ''
    }
  }
}
</script>

<style scoped>
</style>