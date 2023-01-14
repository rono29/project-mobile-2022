package com.example.infokampus2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.infokampus2.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.tvToRegister.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        binding.btnLogin.setOnClickListener{
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener{
            val email = binding.edtEmailLogin.text.toString()
            val password = binding.edtPasswordLogin.text.toString()

//          validasi email
            if(email.isEmpty()){
                binding.edtEmailLogin.error = "Sertakan Informasi Email Anda !"
                binding.edtEmailLogin.requestFocus()
                return@setOnClickListener
            }
//            validasi email tidak sama
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.edtEmailLogin.error = "Sertakan Email Yang Valid !"
                binding.edtEmailLogin.requestFocus()
                return@setOnClickListener
            }
//            validasi password
            if(password.isEmpty()){
                binding.edtPasswordLogin.error = "Isi Password Anda !"
                binding.edtPasswordLogin.requestFocus()
                return@setOnClickListener
            }
            LoginFirebase(email,password)
        }
    }

    private fun LoginFirebase(email: String, password: String) {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this){
                    if(it.isSuccessful){
                        Toast.makeText(this, "Selamat Datang $email", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this,DashboardActivity::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this,"${it.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
        }

    }
