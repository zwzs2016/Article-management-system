import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

const index=()=>import('@/components/pages/index.vue')
const login=()=>import('@/components/pages/login.vue')
const register=()=>import('@/components/pages/register.vue')

export default new Router({
	mode:'history',
    routes:[
        {
            path:'/',
            component:index,
			children:[
				{
					path:'publish',
					component:()=>import('@/components/pages/publish.vue')
				},
				{
					path:'queryarticle',
					component:()=>import('@/components/pages/queryarticle.vue')
				},
				
			]
        },
		{
			path:'/login',
			component:login,
			children:[
			// {
				// path:'',
				
			// }
			]
		},
		{
			path:'/register',
			component:register,
			children:[
			// {
				// path:'',
				
			// }
			]
		}
    ]
})