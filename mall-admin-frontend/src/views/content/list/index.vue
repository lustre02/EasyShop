<template>
  <div class="app-container">
    <el-table
      v-loading="listLoading"
      :data="list"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row
    >
      <el-table-column align="center" width="90" label="ID">
        <template slot-scope="scope">
          {{ scope.row.id }}
        </template>
      </el-table-column>
      <el-table-column label="标题">
        <template slot-scope="scope">
          {{ scope.row.title }}
        </template>
      </el-table-column>
      <el-table-column label="重定向" width="150" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.redirect }}</span>
        </template>
      </el-table-column>
      <el-table-column label="图片" width="220" align="center">
        <template slot-scope="scope">
          <img :src="scope.row.imageUrl" alt="" width="200">
        </template>
      </el-table-column>
      <el-table-column class-name="status-col" label="内容" align="center">
        <template slot-scope="scope">
          {{ scope.row.content }}
        </template>
      </el-table-column>
      <el-table-column align="center" prop="created_at" label="操作" width="200">
        <template slot-scope="scope">
          <el-button type="danger" icon="el-icon-delete" circle @click="del(scope.row)" />
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      background
      layout="prev, pager, next"
      :total="total"
      :current-page="currentPage"
      @current-change="currentChange"
    />
  </div>
</template>

<script>
import { getTotal } from '@/api/content'
import { getPageByCategoryId } from '@/api/content'
import { del } from '@/api/content'

export default {
  filters: {
    statusFilter(status) {
      const statusMap = {
        published: 'success',
        draft: 'gray',
        deleted: 'danger'
      }
      return statusMap[status]
    }
  },
  data() {
    return {
      list: null,
      listLoading: true,
      total: 0,
      currentPage: 1
    }
  },
  created() {
    this.fetchTotal()
    this.fetchPage(1, 10)
  },
  methods: {
    currentChange(e) {
      this.currentPage = e
      this.fetchPage(e, 10)
    },
    fetchTotal() {
      if (!isNaN(this.$route.query.categoryId)) {
        getTotal(this.$route.query.categoryId).then(response => {
          if (response.code === 20000) {
            this.total = response.data.total
          }
        })
      }
    },
    fetchPage(pageNum, pageSize) {
      this.listLoading = true
      if (!isNaN(this.$route.query.categoryId)) {
        getPageByCategoryId(this.$route.query.categoryId, pageNum, pageSize).then(response => {
          if (response.code === 20000) {
            this.list = response.data
          }
        })
      }
      this.listLoading = false
    },
    del(row) {
      console.log(row)
      del(row.id).then(response => {
        if (response.code === 20000) {
          this.$message.success('删除成功')
          this.fetchPage(this.currentPage, 10)
        }
      })
    }
  }
}
</script>
<style scoped>
  .el-pagination{
    text-align: center;
    margin-top: 20px;
  }
</style>
