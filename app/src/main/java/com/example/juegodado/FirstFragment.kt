package com.example.juegodado

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

import androidx.navigation.fragment.findNavController
import com.example.juegodado.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btRoll.setOnClickListener{
            val oDado= Dado()

            val dadoOne:Int=BuscarDado()
            val dadoTwo:Int=BuscarDado()

            binding.imageViewDados.setImageResource(dadoOne)
            binding.imageViewDado2.setImageResource(dadoTwo)
            binding.imageViewDados.contentDescription=oDado.toString()
            binding.imageViewDado2.contentDescription=oDado.toString()
            Comparar(dadoOne,dadoTwo)

        }
    }

   private fun BuscarDado(): Int {
       val oDado= Dado()
       val Dado= when(oDado.Roll()){
           1->R.drawable.dice_1
           2->R.drawable.dice_2
           3->R.drawable.dice_3
           4->R.drawable.dice_4
           5->R.drawable.dice_5
           else ->R.drawable.dice_6
       }
       return Dado
   }

    private fun Comparar(dadoOne:Int,dadoTwo:Int):Boolean{

        if(dadoOne.equals(dadoTwo)){
            val toast= Toast.makeText(requireActivity(), "GANASTE " , Toast.LENGTH_SHORT)
            toast.show()
            return true
        }else{
            val toast= Toast.makeText(requireActivity(), "PERDISTE " , Toast.LENGTH_SHORT)
            toast.show()
           return false
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}