<template>
    <div class="window">  
        <div class="search">
            <order-search-bar @onSearch="searchOrder" ref="orderSearchBar"></order-search-bar>
        </div> 

        <el-table
        class="table"
        :data="orderTable"
        stripe
        style="width: 100%">
            <el-table-column
                prop="id"
                label="id"
                width="250">
            </el-table-column>
            <el-table-column
                prop="course_id"
                label="课程编号"
                width="250">
            </el-table-column>
            <el-table-column
                prop="user_id"
                label="用户编号"
                width="250">
            </el-table-column>
            <el-table-column
                prop="date"
                label="下单日期"
                width="250">
            </el-table-column>
            <el-table-column
                prop="price"
                label="价格"
                width="250">
            </el-table-column>
            <el-table-column
                label="操作"
                width="250">
            <template slot-scope="scope">
                <el-button @click="deleteById(scope.row)" type="danger" size="small">删除</el-button>
            </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
    import OrderSearchBar from './OrderSearchBar.vue'
    export default {
        name: 'OrderManage',
        components: {
            OrderSearchBar
        },

        data () {
            return {
                orderTable: [],
            }
        },

        mounted: function () {
            this.loadOrder()
        },

        methods: {
            loadOrder () {
                var _this = this
                this.$axios.get('/order')
                .then(response => {
                    if(response.status === 200) {
                        _this.orderTable = response.data
                    }
                })
            },

            deleteById (row) {
                var url = '/order/' + row.id
                this.$confirm('此操作将永久删除该订单，是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.$axios.delete(url)
                    .then(response => {
                        if(response.status === 200) {
                            this.loadOrder()
                        }
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    })
                })
            },

            searchOrder () {
                var url = '/order/' + this.$refs.orderSearchBar.input
                var _this = this
                this.$axios.get(url)
                .then(respose => {
                    if(respose.status === 200) {
                        _this.orderTable = respose.data
                    }
                })
            }
        },

        
    }
</script>

<style scoped>
.window {
    margin-top: 1%;
}
.search {
    margin-top: 1%;
}
.table {
    margin-top: 1%;
}
</style>