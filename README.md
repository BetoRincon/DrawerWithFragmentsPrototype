### DrawerWithFragmentsPrototype
Este es un prototipo de Drawer usando Fragments y Kotlin. El Drawer se construyo usando la plantilla por defecto que ofrece el Android studio.
La idea con este prototipo es explorar la implementación del menú lateral fijo en la vista principal, y las demás vistas se agregan 
dinámicamente mediante fragments.

### Implementación de Fragments

Se creó la carpeta `/Fragments` en `Fragmentest/app/src/main/java/com.example.fragmenttest/` para almacenar todos los Fragments. En la 
actualidad hay dos de ellos, `MyJobsFragment.kt` y `MyJobsFragment.kt`. Para la creación de cada uno de ellos se usó el template por
defecto y se implementaron los métodos de fábrica.

*Importante: Se debe definir el contenedor dónde se anclarán los fragments, en este caso se encuentra en `content_main.xml` con el 
id `@+id/home`*

En el `MainActivity.kt` antes del método *`onCreate`* se  declaran los fragments de la forma
```kotlin
lateinit var Jobs: JobsFragment
lateinit var  MyJobs: MyJobsFragment
```
para luego ser instanciados dentro de la función 

```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        Jobs = JobsFragment.newInstance("Param 1", "Param 2")
        MyJobs = MyJobsFragment.newInstance("param 1", "param 2")

    }
```

Cuando el usuario hace click en cada elemento del menú, cuando se solicita la vista deseada, se manda a llamar el fragment

```Kotlin

  override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.Jobs -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.home, Jobs)
                    .addToBackStack(Jobs.toString())
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.MyJobs -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.home, MyJobs)
                    .addToBackStack(MyJobs.toString())
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            
            ...

```

Para que el fragment quede bien implementado se debe extender la clase principal con las interfaces `OnFragmentInteractionListener`
de cada una de las clases de los Fragments 

```kotlin
import ...

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,
    JobsFragment.OnFragmentInteractionListener, MyJobsFragment.OnFragmentInteractionListener
{

...

```

y se sobreescribe la función `onFragmentInteraction`

```kotlin
override fun onFragmentInteraction(uri: Uri) {
        Log.d("Mobijob","Fragments Interaction")
    }
```

