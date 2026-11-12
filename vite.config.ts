import { defineConfig } from 'vite';

export default defineConfig({
  // Using relative base ensures assets load correctly both locally and on any GitHub Pages subpath
  base: './',
  build: {
    outDir: 'dist',
    assetsDir: 'assets',
    sourcemap: false
  }
});
