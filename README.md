CardView


0) build.grandle updaten
	    dependencies updaten
    		compile 'com.android.support:support-v4:21.0.3'
    		compile 'com.android.support:cardview-v7:21.+'
    		compile 'com.android.support:recyclerview-v7:21.+'

1) Fragment erstellen
2) Activity mit Fragment verbinden
3) Im Fragment einen RecyclerView hinzufügen

	<android.support.v7.widget.RecyclerView
        android:id="@+id/First_rcRecylcerView"
        android:scrollbars="vertical"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

4) Datenklasse erstellen z.B (Person, ...)

5) ein neues layout.xml erstellen. Dies wird die Cardview

	<android.support.v7.widget.CardView
    		xmlns:android="http://schemas.android.com/apk/res/android"
    		xmlns:card_view="http://schemas.android.com/apk/res-auto"
    		android:id="@+id/card_view"
    		android:orientation="vertical"
			  android:layout_width="match_parent"
			  android:layout_height="wrap_content"
    		android:layout_margin="5dp"
    		card_view:cardElevation="6dp"
    		card_view:cardCornerRadius="4dp">

			<!-- wähle ein layout -->
    		<RelativeLayout
       			android:layout_width="match_parent"
        		android:layout_height="wrap_content"
        		android:id="@+id/listView"
        		android:layout_gravity="center_horizontal">
				
				<!-- importiere hier was du möchtest -->
        		<TextView
            		android:layout_width="wrap_content"
					android:layout_height="wrap_content"
					android:textAppearance="?android:attr/textAppearanceLarge"
					android:text="ID"
					android:id="@+id/CardView_tvID"
					android:layout_alignParentTop="true"
					android:layout_alignParentStart="true" />
				
				<!--				
				<TextView
				.../>
				
				...
				-->

			</RelativeLayout>
</android.support.v7.widget.CardView>

6) erstelle eine Holder klasse

	//extends RecyclerView.ViewHolder
	public class MyViewHolder extends RecyclerView.ViewHolder {

		//Diese Textviews wurden in der cardview.xml definiert
		private final TextView id, forename, surname, add;

		//override default ViewHolder constructor
		public MyViewHolder(View itemView) {
			 super(itemView);
			 
			 //initialisiere UI Elemente mit itemView
			 id = ((TextView)itemView.findViewById(R.id.CardView_tvID));
			 forename = ((TextView)itemView.findViewById(R.id.CardView_tvFirstName));
			 surname = ((TextView)itemView.findViewById(R.id.CardView_tvLastName));
			 add = ((TextView)itemView.findViewById(R.id.CardView_tvADD));
		}

		//UI-Elemente werden befüllt
		public void assignData(Person data){
				id.setText("" + data.id);
				forename.setText(data.firstName);
				surname.setText(data.lastName);
		}
}

7) erstelle ein DataAdapter

	//extends  RecyclerView.Adapter<MyViewHolder> -> MyViewHolder wurde im schritt 6 erstellt
	public class DataAdapter extends  RecyclerView.Adapter<MyViewHolder> {

		private final List<Person> personList;
		private int layout;

		//Übergabe von einer List<T>. Diese Liste wird als einzelne karten im RecyclerView angelegt
		//layout ist die Cardview
		public DataAdapter(List<Person> personList, int layout){
			this.personList = personList;
			this.layout = layout;
		}

		@Override
		public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
			//Hier wird eine Karte erstellt. i ist die ite stelle in der list, die im construkter übergeben wurde.
			View v = LayoutInflater.from(viewGroup.getContext()).inflate(layout, viewGroup, false);

			//hier kann ein clicklistener implementiert werden
			v.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					
				}
			});

			return new MyViewHolder(v);
		}
		
		//standart Override methoden
		@Override
		public void onBindViewHolder(MyViewHolder holder, int position) {
			holder.assignData(personList.get(position));
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public int getItemCount() {
			return personList.size();
		}
}

8) Fragment.jar updaten

		@Override
    	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        	super.onCreateView(inflater, container, savedInstanceState);
        	final View rootView = inflater.inflate(R.layout.fragment_list, container, false);
		
			    //Recyclerview Verbindung über id
        	RecyclerView mRecyclerView = (RecyclerView) rootView.findViewById(R.id.First_rcRecylcerView);
        	mRecyclerView.setHasFixedSize(true);
        	mRecyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));

			    //Recycler mit Adapter verbinden
			    //Übergib eine List von Personen und das cardviewLayout
        	RecyclerView.Adapter mAdapter = new DataAdapter(dataBase.getPersonList(), R.layout.cardviewitem);
        	mRecyclerView.setAdapter(mAdapter);

        	return rootView;
		}
		
################################################################################################################################		
FERTIG
