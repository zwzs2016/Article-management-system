import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const router=new Vuex.Store({
	state:{
		count:1,
		info:true
	},
	mutations:{
		increatecount(state){
			this.count++
		},
		logininfo(state,val){
			this.info=val
		}
	},
	actions:{
		logininfo(context,val){
			context.commit('logininfo',val)
		}
	}
})

export default router