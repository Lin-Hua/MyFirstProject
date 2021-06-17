<template>
  <div>
    <el-table
      :data="books"
      border
      style="width: 90%">
      <el-table-column
        fixed
        prop="bno"
        label="序号"
        min-width="120">
      </el-table-column>
      <el-table-column
        prop="bname"
        label="书名"
        min-width="120">
      </el-table-column>
      <el-table-column
        prop="type"
        label="类型"
        min-width="120">
      </el-table-column>
      <el-table-column
        prop="buyPrice"
        label="进价"
        min-width="120">
      </el-table-column>
      <el-table-column
        prop="sellprice"
        label="售价"
        min-width="120">
      </el-table-column>
      <el-table-column
        fixed="right"
        label="操作"
        min-width="120">
        <template slot-scope="scope">
          <el-button @click="edit(scope.row)" type="text" size="small">编辑</el-button>
          <el-button @click="deletebook(scope.row)" type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'BookList',
  methods: {
    deletebook(row){
      const _this =this
      axios.get('http://localhost:8082/superadmin/deletebook/?id='+row.bno).then(function (resp) {
          _this.$alert('删除成功', '提示', {
            confirmButtonText: '确定',
            callback: action => {
              window.location.reload();
            }
        })
      })
    },
    edit(row) {
      this.$router.push({
        path:'/bookUpdata',
        query:{
          bno:row.bno
        }
      })
    }
  },
  data () {
    return {
      msg: 'Hello word',
      books: [],
      open_list:["2"]
    }
  },
  created () {
    const _this = this
    // eslint-disable-next-line no-unused-expressions,no-undef
    axios.get('http://localhost:8082/superadmin/findAll').then(function (resp) {
      _this.books = resp.data
    })
  }
}
</script>

<style scoped>
</style>
