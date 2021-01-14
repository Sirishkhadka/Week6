package com.sirish.softuserclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.sirish.softuserclone.`object`.Student
import com.sirish.softuserclone.fragments.AboutFragment
import com.sirish.softuserclone.fragments.AddStudentFragment
import com.sirish.softuserclone.fragments.HomeFragment
import com.sirish.softuserclone.model.student
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigation:BottomNavigationView
    lateinit var linear:LinearLayout
    var studentArrayList:ArrayList<student>?= ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val homeFragment=HomeFragment()
        val addStudentFragment=AddStudentFragment()
        val aboutUsFragment=AboutFragment()
        linear=findViewById(R.id.linear)

        Student.addStudent()
        makeCurrentFragment(homeFragment)

        bottomNavigation=findViewById(R.id.bottomNavigation)
        bottomNavigation.setOnNavigationItemSelectedListener {item->
            when(item.itemId){
                R.id.icHome ->{makeCurrentFragment(homeFragment)
                    true
                }
                R.id.icAddStudent ->{makeCurrentFragment(addStudentFragment)
                    true
                }
                R.id.icAbout ->{makeCurrentFragment(aboutUsFragment)
                    true
                }

                else -> false
            }
        }

        bottomNavigation.setOnNavigationItemReselectedListener {item->
            when(item.itemId){
                R.id.icHome ->{makeCurrentFragment(homeFragment)
                    true
                }
                R.id.icAddStudent ->{makeCurrentFragment(addStudentFragment)
                    true
                }
                R.id.icAbout ->{makeCurrentFragment(aboutUsFragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun makeCurrentFragment(fragment:Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.linear, fragment)
            // setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            commit()
        }
    }

}