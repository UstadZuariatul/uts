package com.example.zuritauluts.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zuritauluts.DetailKomikActivity
import com.example.zuritauluts.Komik
import com.example.zuritauluts.R


class UntukmuFragment : Fragment() {
    private lateinit var adapter: komikAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var komikArrayList: ArrayList<Komik>

    lateinit var image: Array<Int>
    lateinit var detailimage: Array<Int>
    lateinit var title: Array<String>
    lateinit var description: Array<String>
    lateinit var chapter: Array<String>

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_untukmu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_komik)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = context?.let {
            komikAdapter(it, komikArrayList){
                val intent = Intent(context, DetailKomikActivity::class.java)
                intent.putExtra(INTENT_PARCELABLE, it)
                startActivity(intent)
            }
        }

    }
    private fun dataInitialize(){
        komikArrayList = arrayListOf<Komik>()

        detailimage = arrayOf(
            R.drawable.img,
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4,
            R.drawable.img_5,
            R.drawable.img_6,
            R.drawable.img_7,
            R.drawable.img_8,
            R.drawable.khairi,
        )

        image = arrayOf(
            R.drawable.img,
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4,
            R.drawable.img_5,
            R.drawable.img_6,
            R.drawable.img_7,
            R.drawable.img_8,
            R.drawable.khairi,
        )

        title = arrayOf(
            "ustad adi hidayat",
            "ustad abdul shomad",
            "ustad dasad latif",
            "ustad hanan attaki",
            "ustad handy bonny",
            "ustad yahya",
            "ustad yahya waloni",
            "ustad syam",
            "ustad maulana",
            "calon ustad zuriatul khairi",

            )

        description = arrayOf(
          "seorang ustaz Indonesia yang menjabat Wakil Ketua I Majelis Tabligh Pimpinan Pusat Muhammadiyah periode 2022-2027.",
            "seorang da'i atau penceramah agama Islam dari Indonesia yang terutama berfokus dalam bidang ilmu hadis dan fikih.",
            "seorang ulama, akademikus, dan dosen ilmu komunikasi berkebangsaan Indonesia yang aktif mengajar di Universitas Hasanuddin",
            "seorang pendakwah Indonesia yang menyampaikan ceramah yang dekat dengan keseharian dan gaya anak muda. ",
            "salah satu ustadz yang mempunyai gaya nyentrik ala anak muda. Meski gaya fashionnya seperti anak muda, ia adalah seorang pendakwah yang giat mendakwahkan ajaran Islam, terutama untuk anak muda.",
            "pengasuh Lembaga Pengembangan Da'wah dan Pondok Pesantren Al-Bahjah yang berpusat di Cirebon Kelahiran: 10 Agustus 1973 (usia 49 tahun), Blitar",
            "pendakwah Islam Indonesia. Yahya Yopie Waloni dilahirkan sebagai penganut Kristiani di Manado, Sulawesi Utara pada 30 November 1970",
            "seorang penulis naskah, muadzin dan dai. Dakwah awalnya dari penulis naskah ceramah Ustaz Maulana kemudian Ustaz Syam pun mendapatkan tawaran untuk menyampaikan dakwah juga.",
            "seorang dai atau pendakwah yang menampilkan dakwahnya dengan bahasa dan cara penyampaian yang sangat mudah diterima oleh masyarakat.",
            "seorang yang insyaallah akan menjadi ustad & mengidolakan ustad abdul shomad",
            )

        chapter = arrayOf(
            "Chapter 2",
            "Chapter 5",
            "Chapter 4",
            "Chapter 2",
            "Chapter 6",
            "Chapter 3",
            "Chapter 5",
            "Chapter 4",
            "Chapter 4",
            "Chapter 5",
        )
        for (i in image.indices){
            val komik = Komik(image[i], title[i], description[i], detailimage[i], chapter[i],)
            komikArrayList.add(komik)
        }
    }


}