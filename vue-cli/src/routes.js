import Home from './components/Home.vue';
import Topics from './components/Topics.vue';
import TopicWithComments from './components/TopicWithComments.vue';
import AddTopic from './components/AddTopic.vue';
import AddComment from './components/AddComment.vue';

export const routes = [
    { path: '/', component: Home },
    { path: '/topics', component: Topics, //can put id here.
    // children: [
    //   {
    //     // UserProfile will be rendered inside User's <router-view>
    //     // when /user/:id/profile is matched
    //     path: 'show',
    //     component: TopicWithComments
    //   }
    // ]
    },
    { path: '/topics/show', component: TopicWithComments
    },
    { path: '/topics/create', component: AddTopic },
    { path: '/topics/show/addcomment', component: AddComment },
  ]