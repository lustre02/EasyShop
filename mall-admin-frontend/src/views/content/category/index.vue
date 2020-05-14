<template>
  <div class="app-container">

    <el-tree
      ref="tree2"
      :data="data2"
      :props="defaultProps"
      :filter-node-method="filterNode"
      class="filter-tree"
      default-expand-all
      @node-click="redirectList"
    />

  </div>
</template>

<script>
import { getTree } from '@/api/content-category'

export default {
  data() {
    return {
      filterText: '',
      data2: [],
      defaultProps: {
        children: 'children',
        label: 'label'
      }
    }
  },
  watch: {
    filterText(val) {
      this.$refs.tree2.filter(val)
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    filterNode(value, data) {
      if (!value) return true
      return data.label.indexOf(value) !== -1
    },
    fetchData() {
      getTree().then(response => {
        if (response.code === 20000) {
          this.data2 = response.data
        }
      })
    },

    redirectList(e) {
      this.$router.push({
        path: '/content/list',
        query: { categoryId: e.id }
      })
    }
  }
}
</script>

