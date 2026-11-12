import { SERVICES_DATA, GALLERY_DATA, PORTFOLIO_INFO, GalleryItem, CustomerReview } from './data/portfolio.ts';

document.addEventListener('DOMContentLoaded', () => {
  renderServices();
  renderGallery('all');
  initGalleryFilters();
  initImageModal();
  initEstimator();
  initInquiryForm();
  renderReviews();
});

// 1. Render Services
function renderServices() {
  const container = document.getElementById('servicesContainer');
  if (!container) return;

  container.innerHTML = SERVICES_DATA.map(service => {
    const iconSymbol = service.category === 'electrical' ? '⚡' : (service.category === 'sanitary' ? '🚰' : '⚙️');
    const bg = service.category === 'electrical' ? '#FEF3C7' : (service.category === 'sanitary' ? 'var(--sky-blue-container)' : '#E0F7FA');

    const itemsHtml = service.items.map(item => `
      <li>
        <svg width="18" height="18" viewBox="0 0 24 24" fill="currentColor">
          <path d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm-2 15l-5-5 1.41-1.41L10 14.17l7.59-7.59L19 8l-9 9z"/>
        </svg>
        <span>${item}</span>
      </li>
    `).join('');

    const whatsappMsg = encodeURIComponent(`আসসালামু আলাইকুম মাজু ভাই। আমি '${service.title}' সেবার ব্যাপারে আপনার সাথে কথা বলতে আগ্রহী।`);
    const whatsappLink = `${PORTFOLIO_INFO.whatsappUrl}?text=${whatsappMsg}`;

    return `
      <div class="card service-card">
        <div class="service-card-header">
          <div class="service-icon-box" style="background-color: ${bg};">
            ${iconSymbol}
          </div>
          <div>
            <h3 style="font-size: 1.15rem; font-weight: 700; color: var(--navy-dark);">${service.title}</h3>
            <p style="font-size: 0.85rem; color: var(--text-muted);">${service.subtitle}</p>
          </div>
        </div>
        <ul class="service-items-list">
          ${itemsHtml}
        </ul>
        <a href="${whatsappLink}" class="btn btn-outline" style="width: 100%;" target="_blank" rel="noopener noreferrer">
          এই সেবার জন্য কথা বলুন
        </a>
      </div>
    `;
  }).join('');
}

// 2. Render Gallery
function renderGallery(filterCategory: string) {
  const grid = document.getElementById('galleryGrid');
  if (!grid) return;

  const items = filterCategory === 'all' 
    ? GALLERY_DATA 
    : GALLERY_DATA.filter(item => item.category === filterCategory);

  grid.innerHTML = items.map(item => `
    <div class="gallery-item-card" data-id="${item.id}">
      <div class="gallery-thumb-wrap">
        <img src="${item.image}" alt="${item.title}" loading="lazy">
        <div class="gallery-tags">
          <span class="gallery-tag">${item.categoryLabel}</span>
          ${item.isSample ? '<span class="gallery-tag gallery-tag-sample">সার্ভিস নমুনা</span>' : ''}
        </div>
      </div>
      <div class="gallery-info">
        <h3 class="gallery-title">${item.title}</h3>
        <p class="gallery-desc">${item.description}</p>
      </div>
    </div>
  `).join('');

  // Attach click listeners to cards
  grid.querySelectorAll('.gallery-item-card').forEach(card => {
    card.addEventListener('click', () => {
      const id = card.getAttribute('data-id');
      const found = GALLERY_DATA.find(i => i.id === id);
      if (found) {
        openImageModal(found);
      }
    });
  });
}

function initGalleryFilters() {
  const filterBtns = document.querySelectorAll('#galleryFilters .filter-btn');
  filterBtns.forEach(btn => {
    btn.addEventListener('click', () => {
      filterBtns.forEach(b => b.classList.remove('active'));
      btn.classList.add('active');
      const filter = btn.getAttribute('data-filter') || 'all';
      renderGallery(filter);
    });
  });
}

// 3. Image Modal Lightbox
function initImageModal() {
  const modal = document.getElementById('imageModal');
  const closeBtn = document.getElementById('modalCloseBtn');
  if (!modal || !closeBtn) return;

  closeBtn.addEventListener('click', () => {
    modal.classList.remove('active');
  });

  modal.addEventListener('click', (e) => {
    if (e.target === modal) {
      modal.classList.remove('active');
    }
  });

  document.addEventListener('keydown', (e) => {
    if (e.key === 'Escape' && modal.classList.contains('active')) {
      modal.classList.remove('active');
    }
  });
}

function openImageModal(item: GalleryItem) {
  const modal = document.getElementById('imageModal');
  const img = document.getElementById('modalImg') as HTMLImageElement;
  const tag = document.getElementById('modalCategoryTag');
  const title = document.getElementById('modalTitle');
  const desc = document.getElementById('modalDesc');
  const waBtn = document.getElementById('modalWhatsAppBtn') as HTMLAnchorElement;

  if (!modal || !img || !tag || !title || !desc || !waBtn) return;

  img.src = item.image;
  img.alt = item.title;
  tag.textContent = `${item.categoryLabel} • সার্ভিস নমুনা`;
  title.textContent = item.title;
  desc.textContent = item.description;

  const msg = encodeURIComponent(`আসসালামু আলাইকুম মাজু ভাই। আপনার গ্যালারির '${item.title}' কাজের মতো আমার বাসায় কাজ করাতে চাই। বিস্তারিত আলোচনা করতে আগ্রহী।`);
  waBtn.href = `${PORTFOLIO_INFO.whatsappUrl}?text=${msg}`;

  modal.classList.add('active');
}

// 4. Estimator Modal & Calculator
function initEstimator() {
  const openBtn = document.getElementById('openEstimatorBtn');
  const modal = document.getElementById('estimatorModal');
  const closeBtn = document.getElementById('estimatorCloseBtn');
  const sendBtn = document.getElementById('sendEstimatorWhatsAppBtn') as HTMLAnchorElement;

  if (!modal || !closeBtn) return;

  if (openBtn) {
    openBtn.addEventListener('click', () => modal.classList.add('active'));
  }
  closeBtn.addEventListener('click', () => modal.classList.remove('active'));
  modal.addEventListener('click', (e) => {
    if (e.target === modal) modal.classList.remove('active');
  });

  let switchCount = 10;
  let lightCount = 8;
  let bathCount = 1;

  const countSwitch = document.getElementById('countSwitch');
  const countLight = document.getElementById('countLight');
  const countBath = document.getElementById('countBath');
  const checkDb = document.getElementById('checkDb') as HTMLInputElement;
  const checkPump = document.getElementById('checkPump') as HTMLInputElement;

  function updateWhatsAppLink() {
    if (!sendBtn) return;
    const dbVal = checkDb && checkDb.checked ? 'হ্যাঁ' : 'না';
    const pumpVal = checkPump && checkPump.checked ? 'হ্যাঁ' : 'না';

    const text = `আসসালামু আলাইকুম মাজু ভাই। আমার বাসাবাড়ির কাজের একটি হিসাব প্রয়োজন:
- সুইচ/সকেট পয়েন্ট: ${switchCount} টি
- লাইট/ফ্যান পয়েন্ট: ${lightCount} টি
- বাথরুম স্যানিটারি: ${bathCount} টি
- মেইন ডিবি বোর্ড: ${dbVal}
- পানির মোটর স্থাপন: ${pumpVal}
এ কাজের সম্ভাব্য বাজেট ও সময় কেমন লাগতে পারে জানালে উপকৃত হতাম।`;

    sendBtn.href = `${PORTFOLIO_INFO.whatsappUrl}?text=${encodeURIComponent(text)}`;
  }

  document.getElementById('incSwitch')?.addEventListener('click', () => { switchCount++; if(countSwitch) countSwitch.textContent = String(switchCount); updateWhatsAppLink(); });
  document.getElementById('decSwitch')?.addEventListener('click', () => { if (switchCount > 0) switchCount--; if(countSwitch) countSwitch.textContent = String(switchCount); updateWhatsAppLink(); });

  document.getElementById('incLight')?.addEventListener('click', () => { lightCount++; if(countLight) countLight.textContent = String(lightCount); updateWhatsAppLink(); });
  document.getElementById('decLight')?.addEventListener('click', () => { if (lightCount > 0) lightCount--; if(countLight) countLight.textContent = String(lightCount); updateWhatsAppLink(); });

  document.getElementById('incBath')?.addEventListener('click', () => { bathCount++; if(countBath) countBath.textContent = String(bathCount); updateWhatsAppLink(); });
  document.getElementById('decBath')?.addEventListener('click', () => { if (bathCount > 0) bathCount--; if(countBath) countBath.textContent = String(bathCount); updateWhatsAppLink(); });

  checkDb?.addEventListener('change', updateWhatsAppLink);
  checkPump?.addEventListener('change', updateWhatsAppLink);

  updateWhatsAppLink();
}

// 5. Quick Inquiry Form
function initInquiryForm() {
  const form = document.getElementById('inquiryForm');
  if (!form) return;

  form.addEventListener('submit', (e) => {
    e.preventDefault();
    const name = (document.getElementById('inqName') as HTMLInputElement)?.value.trim();
    const location = (document.getElementById('inqLocation') as HTMLInputElement)?.value.trim();
    const details = (document.getElementById('inqDetails') as HTMLTextAreaElement)?.value.trim();

    const msg = `আসসালামু আলাইকুম মাজু ভাই।${name ? ` আমার নাম: ${name}।` : ''}${location ? ` এলাকা: ${location}।` : ''}${details ? ` কাজের বিবরণ: ${details}।` : ''} এ ব্যাপারে আপনার সাথে কথা বলতে চাই।`;
    window.open(`${PORTFOLIO_INFO.whatsappUrl}?text=${encodeURIComponent(msg)}`, '_blank');
  });
}

// 6. Reviews Section with LocalStorage
function renderReviews() {
  const container = document.getElementById('reviewsContainer');
  if (!container) return;

  const stored = localStorage.getItem('maju_reviews');
  const reviews: CustomerReview[] = stored ? JSON.parse(stored) : [];

  if (reviews.length === 0) {
    container.innerHTML = `
      <div class="reviews-empty">
        <div style="font-size: 2.2rem; margin-bottom: 8px;">💬</div>
        <h3 style="font-size: 1.15rem; font-weight: 700; color: var(--navy-dark);">সম্মানিত গ্রাহকদের মতামত শীঘ্রই এখানে যুক্ত হবে</h3>
        <p style="color: var(--text-secondary); max-width: 580px; margin: 8px auto 16px; font-size: 0.95rem; line-height: 1.7;">
          কাজের শতভাগ সততা ও স্বচ্ছতা বজায় রাখতে কোনো ভুয়া মতামত বা রেটিং প্রদর্শন করা হয় না। আপনি যদি আমার কাজের সেবা গ্রহণ করে থাকেন, তবে আপনার মূল্যবান অভিজ্ঞতা হোয়াটসঅ্যাপে বা সরাসরি জানাতে পারেন।
        </p>
        <a href="${PORTFOLIO_INFO.whatsappUrl}?text=${encodeURIComponent('আসসালামু আলাইকুম মাজু ভাই। আপনার কাজের ব্যাপারে আমার মতামত জানাতে চাই:')}" class="btn btn-outline" target="_blank" rel="noopener noreferrer">
          মতামত জানান
        </a>
      </div>
    `;
  } else {
    const listHtml = reviews.map(r => `
      <div style="padding: 14px 0; border-bottom: 1px solid var(--surface-border);">
        <div style="display: flex; justify-content: space-between; align-items: center;">
          <div>
            <strong>${r.name}</strong> <span style="font-size: 0.85rem; color: var(--text-muted);">(${r.location} • ${r.serviceTaken})</span>
          </div>
          <div style="color: var(--electric-yellow);">★ ${r.rating}/5</div>
        </div>
        <p style="color: var(--text-secondary); margin-top: 6px; font-size: 0.95rem;">${r.comment}</p>
        <span style="font-size: 0.75rem; color: var(--text-muted);">${r.date}</span>
      </div>
    `).join('');

    container.innerHTML = `
      <div>
        <h3 style="font-size: 1.1rem; font-weight: 700; color: var(--navy-dark); margin-bottom: 12px;">গ্রাহকদের সাম্প্রতিক প্রতিক্রিয়া</h3>
        ${listHtml}
      </div>
    `;
  }
}
