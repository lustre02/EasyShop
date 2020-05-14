<template>
  <div class="app-container">

    <el-tree
      ref="tree2"
      :data="data2"
      :props="defaultProps"
      :filter-node-method="filterNode"
      class="filter-tree"
    />

  </div>
</template>

<script>
import { getTree } from '@/api/item-cat'

export default {

  data() {
    return {
      filterText: '',
      data2: [],
      defaultProps: {
        children: 'children',
        label: 'name'
      }
    }
  },
  watch: {
    filterText(val) {
      this.$refs.tree2.filter(val)
    }
  },
  created() {
    this.fetchItemCatTree()
  },
  methods: {
    filterNode(value, data) {
      if (!value) return true
      return data.label.indexOf(value) !== -1
    },
    fetchItemCatTree() {
      getTree().then(response => {
        if (response.code === 20000) {
          this.data2 = response.data
        }
      })
    }
  }
}
</script>

