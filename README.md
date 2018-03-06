# Pit

Hi Tomer, here is the answer for your assigment.

## Getting Started

To start - fork and clone project.

### How to use
The core of Pit is PitViewGroup. That's custom ViewGroup, which do all work.
You can set up PitViewGroup in simple way:

### Example 1 (only add button):
```
    private PitViewGroup pitViewGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pit_view);
        pitViewGroup = findViewById(R.id.pitActivityPitView);
        initFAB();
    }

    private void initFAB() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabActivityPitView);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pitViewGroup.addNewPoint();
            }
        });
    }
```

### Example 2 (predefine points add button):

```

    private PitViewGroup pitViewGroup;
    private ArrayList<PitPoint> defaultPoints;

    @Override
    public View onCreate(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pit_in_fragment, container, false);
        pitViewGroup = view.findViewById(R.id.pitInFragment);
        initDefaultPoints();
        pitViewGroup.setPoints(defaultPoints);
        return view;
    }

    private void initDefaultPoints() {
        defaultPoints = new ArrayList<>();
        defaultPoints.add(new PitPoint(200,100));
        defaultPoints.add(new PitPoint(400,800));
        defaultPoints.add(new PitPoint(500,130));
    }
    
    public void addPoint(){
        pitViewGroup.addNewPoint();
    }
   ```

## Authors

* **Vitalii Kravchuk** - *Initial work*
