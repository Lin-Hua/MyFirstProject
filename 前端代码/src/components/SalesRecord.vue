<template>
  <div>
    <el-table
      :data="records"
      border
      style="width: 90%">
      <el-table-column
        fixed
        prop="orderno"
        label="订单编号"
        min-width="120">
      </el-table-column>
      <el-table-column
        prop="sno"
        label="销售人员编号"
        min-width="120">
      </el-table-column>
      <el-table-column
        prop="mno"
        label="客户编号"
        min-width="120">
      </el-table-column>
      <el-table-column
        prop="bno"
        label="图书编号"
        min-width="120">
      </el-table-column>
      <el-table-column
        prop="saletime"
        label="日期"
        min-width="120">
      </el-table-column>
      <el-table-column
        fixed="right"
        label="操作"
        min-width="120">
        <template slot-scope="scope">
          <el-button @click="edit(scope.row)" type="text" size="small">编辑</el-button>
          <el-button @click="deleteSaleRecord(scope.row)" type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'SaleRecord',
  methods: {
    deleteSaleRecord(row){
      const _this =this
      axios.get('http://localhost:8082/superadmin/deletesale/?id='+row.orderno).then(function (resp) {
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
        path:'/saleRecordUpdata',
        query:{
          orderno:row.orderno
        }
      })
    }
  },
  data () {
    return {
      msg: 'Hello word',
      records: []
    }
  },
  created () {
    const _this = this
    // eslint-disable-next-line no-unused-expressions,no-undef
    axios.get('http://localhost:8082/superadmin/listsale').then(function (resp) {
      _this.records = resp.data
    })
  }
}
</script>

<style scoped>

</style>
