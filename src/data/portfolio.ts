export interface ServiceItem {
  id: string;
  title: string;
  subtitle: string;
  category: 'electrical' | 'sanitary' | 'pump';
  items: string[];
}

export interface GalleryItem {
  id: string;
  title: string;
  category: 'electrical' | 'sanitary' | 'pump';
  categoryLabel: string;
  image: string;
  description: string;
  isSample: boolean;
}

export interface CustomerReview {
  id: string;
  name: string;
  location: string;
  serviceTaken: string;
  rating: number;
  comment: string;
  date: string;
}

export const PORTFOLIO_INFO = {
  name: "মাজু ইলেকট্রিশিয়ান",
  experience: "৮ বছরের বেশি অভিজ্ঞতা",
  profession: "ইলেকট্রিক্যাল ও স্যানিটারি কাজের কারিগর",
  locationPrimary: "ত্রিশাল, ময়মনসিংহ, বাংলাদেশ",
  phone: "01999234828",
  whatsapp: "01758663620",
  whatsappUrl: "https://wa.me/8801758663620",
  callUrl: "tel:+8801999234828",
  facebookUrl: "https://www.facebook.com/share/1cdgq2jxQt/",
  introText: "আসসালামু আলাইকুম। আমি মাজু ইলেকট্রিশিয়ান। দীর্ঘ ৮ বছরের বেশি সময় ধরে বাসাবাড়ির বৈদ্যুতিক ওয়্যারিং, নতুন বাড়ির বৈদ্যুতিক সংযোগ, সুইচ-সকেট ও লাইট-ফ্যান ফিটিং, বাথরুমের স্যানিটারি কাজ এবং পানির মোটর স্থাপনের কাজ করে আসছি। আমি ত্রিশাল, ময়মনসিংহ এবং প্রয়োজন অনুযায়ী ময়মনসিংহ জেলার বিভিন্ন এলাকায় সেবা দিয়ে থাকি।",
  aboutText: "আমি কাজের গুণমান এবং নিরাপত্তাকে সর্বোচ্চ অগ্রাধিকার দিই। বৈদ্যুতিক কাজের প্রতিটি ধাপে সঠিক মাপের তার ও নিরাপত্তা সার্কিট নিশ্চিত করি, যাতে ভবিষ্যতে কোনো দুর্ঘটনার ঝুঁকি না থাকে। স্যানিটারি ও পানির মোটরের কাজে সঠিক প্রেসার এবং লিকেজ-মুক্ত পাইপলাইন সংযোগে বিশেষভাবে যত্নবান থাকি।"
};

export const SERVICES_DATA: ServiceItem[] = [
  {
    id: "electrical",
    title: "বৈদ্যুতিক ওয়্যারিং",
    subtitle: "নিরাপদ, আধুনিক ও ত্রুটিহীন ওয়্যারিং সেবা",
    category: "electrical",
    items: [
      "নতুন বাড়ির সম্পূর্ণ ওয়্যারিং",
      "পুরোনো বাড়ির ওয়্যারিং পরিবর্তন",
      "বৈদ্যুতিক তার সংযোগ",
      "সুইচ ও সকেট স্থাপন",
      "লাইট ও ফ্যান ফিটিং",
      "বৈদ্যুতিক বোর্ড ও এমসিবি স্থাপন"
    ]
  },
  {
    id: "sanitary",
    title: "স্যানিটারি কাজ",
    subtitle: "উন্নত মানের বাথরুম ও পাইপ ফিটিংস",
    category: "sanitary",
    items: [
      "বাথরুমের স্যানিটারি কাজ",
      "কমোড ও বেসিন স্থাপন",
      "পানির কল ও শাওয়ার ফিটিং",
      "পানির পাইপলাইন সংযোগ",
      "নতুন বাথরুমের স্যানিটারি ফিটিং"
    ]
  },
  {
    id: "pump",
    title: "পানির মোটর স্থাপন",
    subtitle: "টেকসই ও লিকেজ-মুক্ত পানির মোটর সংযোগ",
    category: "pump",
    items: [
      "নতুন পানির মোটর স্থাপন",
      "মোটরের পানির পাইপ সংযোগ",
      "প্রয়োজনীয় ফিটিং ও টেস্ট রান"
    ]
  }
];

export const GALLERY_DATA: GalleryItem[] = [
  {
    id: "g1",
    title: "মেইন ডিস্ট্রিবিউশন বোর্ড ও এমসিবি ওয়্যারিং",
    category: "electrical",
    categoryLabel: "বৈদ্যুতিক ওয়্যারিং",
    image: "assets/work/elec_wiring.webp",
    description: "বাসাবাড়ির প্রতিটি রুমের জন্য সঠিক অ্যাম্পিয়ারের সার্কিট ব্রেকার ও কালার-কোডেড তারের সুশৃঙ্খল সংযোগ।",
    isSample: true
  },
  {
    id: "g2",
    title: "আধুনিক সুইচ বোর্ড ও আর্কিটেকচারাল লাইটিং",
    category: "electrical",
    categoryLabel: "বৈদ্যুতিক ওয়্যারিং",
    image: "assets/work/switch_lighting.webp",
    description: "দেয়ালে আধুনিক পিয়ানো/মডুলার সুইচ ও সিলিংয়ে দৃষ্টিসুখকর ওয়ার্ম এলইডি লাইট ফিটিংস।",
    isSample: true
  },
  {
    id: "g3",
    title: "লাক্সারি বাথরুম স্যানিটারি ও শাওয়ার সেটআপ",
    category: "sanitary",
    categoryLabel: "স্যানিটারি কাজ",
    image: "assets/work/sanitary_bath.webp",
    description: "প্রিমিয়াম ক্রোম ওয়াটার শাওয়ার মিক্সার, কল ও কনসিলড পাইপিংয়ের লিকেজ-মুক্ত ফিটিংস।",
    isSample: true
  },
  {
    id: "g4",
    title: "রেসিডেন্সিয়াল ওয়াটার পাম্প মোটর ও পাইপলাইন",
    category: "pump",
    categoryLabel: "পানির মোটর",
    image: "assets/work/water_pump.webp",
    description: "শক্তিশালী পাম্প মোটর ইনস্টলেশন, উচ্চ চাপের পিভিসি পাইপলাইন, প্রেসার গেজ ও নিরাপদ কন্ট্রোল সুইচ।",
    isSample: true
  }
];
