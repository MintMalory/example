public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseInstanceId.getInstance().getToken();
    }
}
