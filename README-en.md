[中文(Chinese)](https://github.com/chaychan/MultipleItemRvAdapter)

#### How to use MultipleItemRvAdapter

**Step1:** Create an ItemProvider for the corresponding entry, inherit the BaseItemProvider, fill in the value of the corresponding viewType in the ItemProviderTag (it is recommended to define the constant in the corresponding adapter, the viewType of each entry must be unique), layout specifies the layout id of the corresponding entry.


For example, a provider of text message entries：

	/**
	 * @author ChayChan
	 * @description TextMessage's itemProvider
	 * @date 2018/3/21  14:43
	 */
    @ItemProviderTag(
        viewType = MessageListAdapter.TYPE_TEXT,
        layout = R.layout.item_text_message
	)
	public class TextMessageItemProvider extends BaseItemProvider<TextMessage> {

	    @Override
	    public void convert(BaseViewHolder helper, TextMessage data, int position) {
	        helper.setText(R.id.tv_text, data.text);
	    }
	
	    @Override
	    public void onClick(BaseViewHolder helper, TextMessage data, int position) {
	        Toast.makeText(mContext, "Click: " + data.text, Toast.LENGTH_SHORT).show();
	    }
	
	    @Override
	    public boolean onLongClick(BaseViewHolder helper, TextMessage data, int position) {
	        Toast.makeText(mContext, "longClick: " + data.text, Toast.LENGTH_SHORT).show();
	        return true;
	    }
	}

A provider of image message entries：

    /**
	 * @author ChayChan
	 * @description ImageMessage's itemProvider
	 * @date 2018/3/21  14:43
	 */
	@ItemProviderTag(
	        viewType = MessageListAdapter.TYPE_IMG,
	        layout = R.layout.item_image_message
	)
	public class ImageMessageItemProvider extends BaseItemProvider<ImageMessage> {
	
	    @Override
	    public void convert(BaseViewHolder helper, ImageMessage data, int position) {
	        ImageView iv = helper.getView(R.id.iv_img);
	        Glide.with(mContext).load(data.imgUrl).into(iv);
	    }
	
	    @Override
	    public void onClick(BaseViewHolder helper, ImageMessage data, int position) {
	        Toast.makeText(mContext, "Click: " + data.imgUrl, Toast.LENGTH_SHORT).show();
	    }
	
	    @Override
	    public boolean onLongClick(BaseViewHolder helper, ImageMessage data, int position) {
	        Toast.makeText(mContext, "longClick: " + data.imgUrl, Toast.LENGTH_SHORT).show();
	        return true;
	    }
	}

&emsp;&emsp;ItemProvider's convert() method is used to handle the corresponding business logic, onClick() is used to process the item's click event, and onLongClick() is used to hold the item's long press event; although click and long press event adapters Can be handled by setOnItemClickListener () and setOnItemLongClickListener (), but here are still the two events in the itemProvider, developers can choose to use one of the ways according to specific needs.


**Step2:**Create a corresponding adapter, inheriting MultipleItemRvAdapter, such as MessageListAdapter:

    /**
	 * @author ChayChan
	 * @description: MessageListAdapter
	 * @date 2018/3/21  14:40
	 */
	
	public class MessageListAdapter extends MultipleItemRvAdapter<Message> {

	    public static final int TYPE_TEXT = 0;
	    public static final int TYPE_IMG = 1;
	
	    public MessageListAdapter(@Nullable List<Message> data) {
	        super(data);

	  		 //If the constructor has other parameters, it needs to be assigned before calling finishInitialize() and assigned to the global variable
	         //This getViewType () and registerItemProvider () method can get the value passed over
	         //getViewType () may be due to some business logic, you need to pass a value to judge, return the corresponding viewType
	         //RegisterItemProvider() can pass value to ItemProvider
	        
			finishInitialize();//Call this method to tell MultipleItemRvAdapter1 that initialization of constructor arguments has been completed
	    }
	
	    @Override
	    protected int getViewType(Message message) {
			//According to the entity class to determine and return the corresponding viewType
	        if (message instanceof TextMessage) {
	            return TYPE_TEXT;
	        } else if (message instanceof ImageMessage) {
	            return TYPE_IMG;
	        }
	        return 0;
	    }
	
	
	    @Override
	    public void registerItemProvider() {
			// Register related entry provider
            mProviderDelegate.registerProvider(new TextMessageItemProvider());
            mProviderDelegate.registerProvider(new ImageMessageItemProvider());
	    }

	}

&emsp;&emsp;Adapter need to implement getViewType () and registerItemProvider () two methods. getViewType() returns a different viewType by judging related logic, and registerItemProvider() is used to register ItemProviders for all sub-items defined by itself.


**Step3:**Set the adapter for RecyclerView:

    	mRvMessages = findViewById(R.id.rv_message);

        mRvMessages.setHasFixedSize(true);
        mRvMessages.setLayoutManager(new LinearLayoutManager(this));

        String imgUrl1 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521627479112&di=7b109af49f8c1c193c3173306cf58680&imgtype=0&src=http%3A%2F%2Fimg.xgo-img.com.cn%2Fpics%2F1538%2F1537620.jpg";
        String imgUrl2 = "https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1521617426&di=d6537bb0ef71984e4a1d14e4b18ba169&src=http://img1d.xgo-img.com.cn/pics/789/788784.jpg";

        mMessages.add(new TextMessage("你好呀，哈哈哈哈，呜啦啦啦啦"));
        mMessages.add(new ImageMessage(imgUrl1));
        mMessages.add(new TextMessage("嗯嗯，今天天气真不错！"));
        mMessages.add(new ImageMessage(imgUrl2));

        mRvMessages.setAdapter(new MessageListAdapter(mMessages));

img：

![](./intro_img/2.jpg)

#### **How to import**

Add the jitpack repository address in allprojects{} in build.gradle in the project root directory, as follows：

    allprojects {
	    repositories {
	        jcenter()
	        maven { url 'https://jitpack.io' }//Add jitpack warehouse address
	    }
	}
 
Open the build.gradle in the app's module, add dependencies in dependencies {} as follows:

    dependencies {
	        compile 'com.github.chaychan:MultipleItemRvAdapter:1.0.2' //It is recommended to use the latest version
	}


The latest version can be viewed

[https://github.com/chaychan/BottomBarLayout/releases](https://github.com/chaychan/MultipleItemRvAdapter/releases)


#### Support and encouragement

If you think my project is helpful to you, star! So I will be more motivated to improve this project：