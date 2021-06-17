import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import BookList from '../components/BookList'
import App from '../App'
import AddBook from '../components/AddBook'
import SearchBook from '../components/SearchBook'
import AccountList from '../components/AccountList'
import SalesRecord from '../components/SalesRecord'
import SalePersonList from '../components/SalePersonList'
import BookUpData from '../components/BookUpData'
import AccoutUpdata from '../components/AccoutUpdata'
import AddAccount from '../components/AddAccount'
import AddSaleRecord from '../components/AddSaleRecord'
import AddSalePerson from '../components/AddSalePerson'
import SalePersonUpdata from '../components/SalePersonUpdata'
import SaleRecordUpdata from '../components/SaleRecordUpdata'
import RecordAnalysis from '../components/RecordAnalysis'

Vue.use(Router)
export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path:'/addAccount',
      component:AddAccount
    },
    {
      path:'/addSaleRecord',
      component:AddSaleRecord
    },
    {
      path:'/recordAnalysis',
      component:RecordAnalysis
    },
    {
      path:'/addSalePerson',
      component:AddSalePerson
    },
    {
      path:'/salePersonUpdata',
      component:SalePersonUpdata
    },
    {
      path:'/saleRecordUpdata',
      component:SaleRecordUpdata
    },
    {
      path:'/accountUpdata',
      component:AccoutUpdata
    },
    {
      path:'/salePersonList',
      component:SalePersonList
    },
    {
      path: '/bookList',
      component: BookList
    },
    {
      path:'/bookUpdata',
      component:BookUpData
    },
    {
      path: '/addBook',
      component:AddBook
    },
    {
      path: '/searchBook',
      component:SearchBook
    },
    {
      path: '/accountList',
      component: AccountList
    },
    {
      path: '/salesRecord',
      component: SalesRecord
    }

  ]
})
