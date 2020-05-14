<template>
  <div class="app-container">
    <el-form ref="form" :model="form" label-width="120px">
      <el-form-item label="类目ID">
        <el-select v-model="form.categoryId" filterable placeholder="请选择">
          <el-option
            v-for="(item,index) in options"
            :key="index"
            :label="item.name"
            :value="item.id"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="重定向">
        <el-input v-model="form.redirect" />
      </el-form-item>
      <el-form-item label="标题">
        <el-input v-model="form.title" />
      </el-form-item>
      <el-form-item label="图片">
        <el-input v-model="form.imageUrl" disabled />
        <el-upload
          class="upload-demo"
          action="http://localhost/api/oss/upload"
          :on-preview="handlePreview"
          :on-remove="handleRemove"
          :on-success="handleSuccess"
          :file-list="fileList"
          name="multipartFile"
          :limit="1"
          list-type="picture"
        >
          <el-button size="small" type="primary">点击上传</el-button>
        </el-upload>
      </el-form-item>
      <el-form-item label="内容">
        <el-input v-model="form.content" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">添加</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { getList } from '../../../api/content-category'
import { add } from '@/api/content'

export default {
  data() {
    return {
      form: {
        categoryId: '',
        title: '',
        redirect: '',
        imageUrl: '',
        content: ''
      },
      options: [],
      fileList: []
    }
  },
  created() {
    this.fetchContentCategoryList()
  },
  methods: {
    onSubmit() {
      add(this.form).then(response => {
        if (response.code === 20000) {
          this.$message.success('添加成功')
        }
      })
    },
    onCancel() {
      this.$message({
        message: 'cancel!',
        type: 'warning'
      })
    },
    handleRemove(file, fileList) {
      console.log(file, fileList)
    },
    handlePreview(file) {
      console.log(file)
    },
    handleSuccess(e) {
      this.form.imageUrl = e.data.url
    },
    handleExceed(files, fileList) {
      this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`)
    },
    beforeRemove(file, fileList) {
      return this.$confirm(`确定移除 ${file.name}？`)
    },
    fetchContentCategoryList() {
      getList().then(response => {
        if (response.code === 20000) {
          this.options = response.data
        }
      })
    }
  }
}
</script>

<style scoped>
  .line{
    text-align: center;
  }
</style>

